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

import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.service.ClienteService;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResources {
	@Inject
	private ClienteService clienteService;

@POST
@Path("/creacion")
public Response crearCliente(Cliente cliente) throws Exception{

	clienteService.crear(cliente);
	return Response.status(Status.CREATED).build();
}

@GET
@Path("/")
public Response listarCliente() throws Exception{
	
	List<Cliente> cliente = clienteService.listar();
	return Response.ok(cliente).build();
}

@GET
@Path("{id}")
public Response buscarCliente(@PathParam("id") String idCliente) throws Exception{
	Cliente cliente = clienteService.obtenerCliente(Integer.parseInt(idCliente));
	return Response.ok(cliente).build();
}

@PUT
@Path("{id}")
public Response modificarCliente(Cliente cliente) throws Exception{
	clienteService.modificarCliente(cliente);
	return null;
}

@DELETE
@Path("{id}")
public Response remove(@PathParam("id") Integer id) throws Exception {
	clienteService.eliminar(id);
	return Response.ok().build();
}

}
