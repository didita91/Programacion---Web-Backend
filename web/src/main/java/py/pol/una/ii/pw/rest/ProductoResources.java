package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.service.ProductoService;
@Path("productos")
public class ProductoResources {
	@Inject
	private ProductoService productoService;
	
@POST
@Path("creacion")
public Response crearProducto(Producto producto) throws Exception{
	productoService.crear(producto);
	return Response.ok("Se creo exitosamente").build();
}

@PUT
@Path("modificacion")
public Response modificarProducto(Producto productoActual,Producto productoNuevo) throws Exception{
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
@Path("busqueda")
public Response buscarProducto(String productoNombre) throws Exception{
	Producto producto = productoService.buscar(productoNombre);
	return Response.ok(producto).build();
}

@DELETE
@Path("eliminacion")
public Response eliminarProducto(String productoNombre) throws Exception{
	productoService.eliminar(productoNombre);
	return Response.ok("Se elimino exitosamente").build();
}
}
