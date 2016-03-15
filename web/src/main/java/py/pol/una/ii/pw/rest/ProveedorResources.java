
package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

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

import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Proveedor;
import py.pol.una.ii.pw.service.ProveedorService;
import py.pol.una.ii.pw.service.ProveedorService;



@Path("/proveedores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProveedorResources {
	@Inject
	private ProveedorService proveedorService;

@POST
@Path("/creacion")
public void crearProveedor(Proveedor proveedor) throws Exception{

	proveedorService.crear(proveedor);
}

@PUT
@Path("{id}")
public Response modificarProveedor(@PathParam("id") Integer idProveedor,Proveedor proveedor) throws Exception{
	proveedorService.modificarProveedor(idProveedor,proveedor);
	return null;


}

@DELETE
@Path("{id}")
public void remove(@PathParam("id") Integer id) throws Exception {
	proveedorService.eliminar(id);
}

@GET
@Path("/")
public Response listarCliente() throws Exception{
	ArrayList<Proveedor> proveedor = proveedorService.listar();
	return Response.ok(proveedor).build();
}

@GET
@Path("{id}")
public Response buscarProveedor(@PathParam("id") Integer idProveedor) throws Exception{
	Proveedor proveedor = proveedorService.find(idProveedor);
	return Response.ok(proveedor).build();
}

}
