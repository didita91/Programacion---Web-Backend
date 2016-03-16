package py.pol.una.ii.pw.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.ejb.EJB;

import py.pol.una.ii.pw.beans.ProductoDuplicadoManager;
import py.pol.una.ii.pw.beans.ProductoManager;
import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.ProductoDuplicado;

public class ProductoService {
	@EJB
	private ProductoManager productoManager;
	@EJB
	private ProductoDuplicadoManager productoDuplicadoManager;
	public void crear(Producto producto) throws SQLIntegrityConstraintViolationException {
		try {
			productoManager.create(producto);

		} catch (Exception e) {
			ProductoDuplicado productoDuplicado = new ProductoDuplicado();
			Producto productoEncontrado=productoManager.findByNombre(producto.getNombre());
			ProductoDuplicado productoDuplicadoEcontrado= productoDuplicadoManager.find(productoEncontrado.getIdProducto());
			if(productoDuplicadoEcontrado!=null){
				productoDuplicadoEcontrado.setCantidad(productoDuplicadoEcontrado.getCantidad()+1);
				productoDuplicadoManager.edit(productoDuplicadoEcontrado);
			}else{
				productoDuplicado.setCantidad(productoDuplicado.getCantidad()+1);
				productoDuplicado.setProducto(productoEncontrado);
				productoDuplicadoManager.create(productoDuplicado);
			}
			throw new SQLIntegrityConstraintViolationException(e.getMessage(), e.getCause());
			
		}
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
