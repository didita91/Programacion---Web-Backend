package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.inject.Inject;

import py.pol.una.ii.pw.beans.VentaManager;
import py.pol.una.ii.pw.model.Venta;

public class VentaService {
	@Inject
	private VentaManager ventaManager;

	public void crear(Venta venta) throws Exception {
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
