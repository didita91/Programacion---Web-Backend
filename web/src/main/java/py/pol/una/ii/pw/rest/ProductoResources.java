package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.service.ProductoService;
@Path("/productos")
public class ProductoResources {
	//@Inject
	//private ProductoService productoService;
	
	@Inject
	private ProductoService productoService;
	
	@POST
	@Path("/creacion")
	@Consumes("application/json")
	public void crearProducto(Producto producto)throws Exception{
	
		productoService.crear(producto);
		
	//	return Response.ok("Se creo exitosamente").build();
	}

	@PUT
	@Path("/modificacion")
	@Consumes("application/json")
	public void modificarProducto(@PathParam("id") Integer id, Producto entity) throws Exception{
		
		productoService.modificarProducto(id, entity);
//		return Response.ok("Se modifico exitosamente").build();
	}	
	
	
	@GET
	@Path("{id}")
	public Response buscarProducto(@PathParam("id") Integer id) throws Exception{
		Producto producto = productoService.find(id);
		return Response.ok(producto).build();
	}
	
	
	@GET
	@Path("/")
	public Response listarProducto() throws Exception{	
		ArrayList<Producto> producto = productoService.listar();
		return Response.ok(producto).build();
	}
}
