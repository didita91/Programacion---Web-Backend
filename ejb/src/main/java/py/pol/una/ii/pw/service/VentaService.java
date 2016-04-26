package py.pol.una.ii.pw.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.validation.ConstraintViolationException;

import org.apache.ibatis.session.SqlSession;

import py.pol.una.ii.pw.beans.ClienteManager;
import py.pol.una.ii.pw.beans.ProductoManager;
import py.pol.una.ii.pw.mapper.ClienteMapper;
import py.pol.una.ii.pw.mapper.VentaDetalleMapper;
import py.pol.una.ii.pw.mapper.VentaMapper;
import py.pol.una.ii.pw.model.CantidadVentaException;
import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;
import py.pol.una.ii.pw.model.VentaDetalle;
import py.pol.una.ii.pw.view.VentaView;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VentaService {
	@EJB
	private ProductoService productoService;
	@EJB
	private ClienteManager clienteManager;

	@EJB
	private ProductoManager productoManager;
	private static boolean rollback = false;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void realizarVenta(VentaView venta) throws Exception,
			CantidadVentaException {
		try {

			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			VentaDetalleMapper mapper = session
					.getMapper(VentaDetalleMapper.class);

			if (venta.getDetalle().isEmpty()) {
				throw new Exception(
						"La venta debe de tener al menos un detalle");
			}

			Integer sumaMonto = 0;
			for (VentaDetalle detalleIt : venta.getDetalle()) {

				Producto producto = productoService.obtenerProducto(detalleIt
						.getIdProducto());
				sumaMonto = sumaMonto
						+ (producto.getPrecio() * detalleIt.getCantidad());
				if (verificarStock(detalleIt, rollback, producto.getStock()) == true) {
					throw new Exception("La cantidad pedida es mayor al stock"); // se

				}
			}
			if (!rollback) {

				for (VentaDetalle vD : venta.getDetalle()) {
					try {
						vD.setIdVenta(venta.getVenta().getIdVenta());
						mapper.insert(vD);
					} catch (Exception e) {
						throw new ConstraintViolationException(e.getMessage(),
								null);
					}
				}
				venta.getVenta().setMonto(sumaMonto);
				ClienteMapper mapperCliente = session
						.getMapper(ClienteMapper.class);
				Cliente cM = mapperCliente.selectByPrimaryKey(venta.getVenta()
						.getIdCliente());
				cM.setSaldo(cM.getSaldo() + sumaMonto);
				mapperCliente.updateByPrimaryKey(cM);
				VentaMapper vm = session.getMapper(VentaMapper.class);
				vm.insert(venta.getVenta());
			}
		} catch (Exception e) {
			throw new CantidadVentaException("Debe ser mayor a 0");
		}
	}

	private boolean verificarStock(VentaDetalle detalle, boolean rollback,
			int stock) {

		if (detalle.getCantidad() > stock) {
			rollback = true;
		}
		return rollback;
	}

}
