
package py.pol.una.ii.pw.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import py.pol.una.ii.pw.model.Proveedor;
import py.pol.una.ii.pw.service.ProveedorService;


@Path("/proveedores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProveedorResources {
	@Inject
	private ProveedorService proveedorService;

@POST
@Path("/creacion")
public Response crearProveedor(Proveedor proveedor) throws Exception{

	proveedorService.crearProveedor(proveedor);
	return Response.status(Status.CREATED).build();

}

@PUT
@Path("{id}")
public Response modificarProveedor(Proveedor proveedor) throws Exception{
	proveedorService.modificarProveedor(proveedor);
	return Response.ok().build();

}

@DELETE
@Path("{id}")
public void remove(@PathParam("id") Integer id) throws Exception {
	proveedorService.eliminar(id);
}

@GET
@Path("/")
public Response listarCliente() throws Exception{
	List<Proveedor> proveedor = proveedorService.listar();
	return Response.ok(proveedor).build();
}

@GET
@Path("{id}")
public Response buscarProveedor(@PathParam("id") Integer idProveedor) throws Exception{
	Proveedor proveedor = proveedorService.obtenerProveedor(idProveedor);
	return Response.ok(proveedor).build();
}

}
