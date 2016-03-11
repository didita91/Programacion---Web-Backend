package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.SessionBean;

import py.pol.una.ii.pw.beans.ProductoManager;
import py.pol.una.ii.pw.model.Producto;

public class ProductoService {
	@EJB
	private ProductoManager productoManager;

	public void crear(Producto producto) throws Exception {
		productoManager.create(producto);
	}

	public void modificarProducto(Integer id, Producto entity) {
		productoManager.edit(entity);
	}

	public void eliminar(Integer idProducto) throws Exception {

		productoManager.remove(productoManager.find(idProducto));
	}

	public ArrayList<Producto> listar() throws Exception {
		

		return (ArrayList<Producto>) productoManager.findAll();
	}

	public Producto find(Integer id) {
		return productoManager.find(id);
	}

}
