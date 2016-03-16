package py.pol.una.ii.pw.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import py.pol.una.ii.pw.beans.VentaDetalleManager;
import py.pol.una.ii.pw.beans.VentaManager;
import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.model.VentaDetalle;

@Stateless
public class VentaService {
	@EJB
	private VentaManager ventaManager;
	@EJB
	private VentaDetalleManager ventaDetalleManager;
	
	private static boolean rollback = false;
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void realizarVenta(Venta venta) throws Exception {
		VentaDetalle detalle= new VentaDetalle();
		
		if(venta.getVentaDetalleCollection().isEmpty()){
			throw new Exception("La venta debe de tener al menos un detalle");
		}
		for(int i =0; i<venta.getVentaDetalleCollection().size() ; i++){
            Iterator detalleIterator = venta.getVentaDetalleCollection().iterator();
            detalleIterator.next();
            try {
               if (detalle.verificarStock(detalleIterator.next(), rollback) == false){
                   throw new Exception("La cantidad es menor a 0"); //se lanza la excepcion
               }
               else{
                   detalle.setVenta(venta);
                   if (!rollback) 
                       entityManager.persist(det);
               }
               if(rollback)
               {
                   if(det.getCantidad()<=0)
                       return 3;
               }

            } catch(ProductoNotFoundException e)
            {
                return 1;
            }
        }
		ventaManager.create(venta);
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
