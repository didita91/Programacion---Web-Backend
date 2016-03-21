package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.validation.ConstraintViolationException;

import py.pol.una.ii.pw.beans.ClienteManager;
import py.pol.una.ii.pw.beans.ProductoManager;
import py.pol.una.ii.pw.beans.VentaDetalleManager;
import py.pol.una.ii.pw.beans.VentaManager;
import py.pol.una.ii.pw.model.CantidadVentaException;
import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.model.VentaDetalle;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VentaService {
	@EJB
	private VentaManager ventaManager;
	@EJB 
	private ClienteManager clienteManager;
	@EJB
	private VentaDetalleManager ventaDetalleManager;
	@Resource
	private SessionContext contex;
	@EJB
	private ProductoManager productoManager;
	private static boolean rollback = false;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void realizarVenta(Venta venta) throws Exception,
			CantidadVentaException {

		VentaDetalle detalle = new VentaDetalle();

		if (venta.getVentaDetalleCollection().isEmpty()) {
			throw new Exception("La venta debe de tener al menos un detalle");
		}
		try {
			Integer sumaMonto=0;
			for (VentaDetalle detalleIt : venta.getVentaDetalleCollection()) {

				Producto producto = productoManager.find(detalleIt
						.getIdProducto().getIdProducto());
				sumaMonto=sumaMonto+(producto.getPrecio()*detalleIt.getCantidad());
				if (detalle.verificarStock(detalleIt, rollback,
						producto.getStock()) == true) {
					throw new Exception("La cantidad pedida es mayor al stock"); // se

				}
			}
			if (!rollback) {

				for (VentaDetalle vD : venta.getVentaDetalleCollection()) {
					try {
						vD.setIdVenta(venta);
						ventaDetalleManager.create(vD);
					} catch (Exception e) {
						throw new ConstraintViolationException(e.getMessage(),null);
					}
				}
				venta.setMonto(sumaMonto);
				Cliente cM = clienteManager.find(venta.getIdCliente().getIdCliente());
				cM.setSaldo(cM.getSaldo()+sumaMonto);
				clienteManager.edit(cM);
				ventaManager.create(venta);
			}
		} catch (Exception e) {
			throw new CantidadVentaException("Debe ser mayor a 0");
		}
	}

	public void modificarVenta(Integer id, Venta entity) {
		ventaManager.edit(entity);
	}

	public void eliminar(Integer idVenta) throws Exception {
		ventaManager.remove(ventaManager.find(idVenta));
	}

	public ArrayList<Venta> listar() throws Exception {

		return (ArrayList<Venta>) ventaManager.findAll();
	}

	public Venta find(Integer id) {
		return ventaManager.find(id);
	}

}
