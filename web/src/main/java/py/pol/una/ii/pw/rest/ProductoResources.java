package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.service.ProductoService;
@Path("/productos")
public class ProductoResources {
	@Inject
	private ProductoService productoService;
	
@POST
@Path("/creacion")
public Response crearProducto(@QueryParam("nombre") String nombre,@QueryParam("precio") String precio, @QueryParam("stock") String stock) throws Exception{
	Producto producto = new Producto();
	producto.setNombre(nombre);
	producto.setPrecio(Integer.parseInt(precio));
	producto.setStock(Integer.parseInt(stock));
	productoService.crear(producto);
	return Response.ok("Se creo exitosamente").build();
}

@PUT
@Path("/modificacion")
public Response modificarProducto(@QueryParam("nombre") String nombre,@QueryParam("precio") String precio, @QueryParam("stock") String stock,@QueryParam("nombre") String nombreNuevo,@QueryParam("precio") String precioNuevo, @QueryParam("stock") String stockNuevo) throws Exception{
	Producto productoActual =new Producto();
	Producto productoNuevo= new Producto();
	productoActual.setNombre(nombre);
	productoActual.setPrecio(Integer.parseInt(precio));
	productoActual.setStock(Integer.parseInt(stock));
	productoActual.setNombre(nombreNuevo);
	productoActual.setPrecio(Integer.parseInt(precioNuevo));
	productoActual.setStock(Integer.parseInt(stockNuevo));
	productoService.modificar(productoActual, productoNuevo);
	return Response.ok("Se modifico exitosamente").build();
}

@GET
@Path("/")
public Response listarProducto() throws Exception{
	ArrayList<Producto> producto = productoService.listar();
	return Response.ok(producto).build();
}

@GET
@Path("/busqueda")
public Response buscarProducto(@QueryParam("nombre") String productoNombre) throws Exception{
	Producto producto = productoService.buscar(productoNombre);
	return Response.ok(producto).build();
}

@DELETE
@Path("/eliminacion")
public Response eliminarProducto(@QueryParam("nombre") String productoNombre) throws Exception{
	productoService.eliminar(productoNombre);
	return Response.ok("Se elimino exitosamente").build();
}
}
