package py.pol.una.ii.pw.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import py.pol.una.ii.pw.beans.ProductoDuplicadoManager;
import py.pol.una.ii.pw.beans.ProductoManager;
import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.ProductoDuplicado;
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class ProductoService {
	@EJB
	private ProductoManager productoManager;
	@EJB
	private ProductoDuplicadoManager productoDuplicadoManager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crear(Producto producto) throws SQLIntegrityConstraintViolationException {
		try {
			productoManager.create(producto);

		} catch (Exception e) {
			ProductoDuplicado productoDuplicado = new ProductoDuplicado();
			Producto productoEncontrado=productoManager.findByNombre(producto.getNombre());
			ProductoDuplicado productoDuplicadoEcontrado= productoDuplicadoManager.findByIdProducto(productoEncontrado);
			if(productoDuplicadoEcontrado.getId_producto_duplicado()!=null){
				productoDuplicadoEcontrado.setCantidad(productoDuplicadoEcontrado.getCantidad()+1);
				productoDuplicadoEcontrado.setProducto(productoEncontrado);
				productoDuplicadoManager.edit(productoDuplicadoEcontrado);
			}else{
				productoDuplicado.setCantidad(productoDuplicado.getCantidad()+1);
				productoDuplicado.setProducto(productoEncontrado);
				productoDuplicadoManager.create(productoDuplicado);
			}
		//	throw new SQLIntegrityConstraintViolationException(e.getMessage(), e.getCause());
			
		}
	}

	public List conectarBD() {
		List<Producto> producto =productoManager.buscarTodo();
		return producto;
	}
	
	public void modificarProducto(Integer id, Producto entity) {
		productoManager.edit(entity);
	}
	

	public void eliminar(Integer idProducto) throws Exception {

		productoManager.remove(productoManager.find(idProducto));
	}

	public List<Producto> listar() throws Exception {
		

		return  productoManager.buscarTodo();
	}

	public Producto find(Integer id) {
		return productoManager.find(id);
	}
	public List<Producto> buscarTodo() {
		
		return productoManager.buscarTodo();
	}
	public void cargasMasivas(Producto producto){
		productoManager.findByNombre(producto.getNombre());
	}

}
