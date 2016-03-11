package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import py.pol.una.ii.pw.beans.VentaManager;
import py.pol.una.ii.pw.model.Venta;

@Stateless
public class VentaService {
	@EJB
	private VentaManager ventaManager;

	public void realizarVenta(Venta venta) throws Exception {
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
