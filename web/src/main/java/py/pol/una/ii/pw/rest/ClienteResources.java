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
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.service.ClienteService;

@Path("/clientes")
public class ClienteResources {
	@Inject
	private ClienteService clienteService;

@POST
@Path("/creacion")
@Consumes("application/json")
public void crearCliente(Cliente cliente) throws Exception{

	clienteService.crear(cliente);
}

@PUT
@Path("{id}")
public Response modificarCliente(@PathParam("id") Integer idCliente,Cliente cliente) throws Exception{
	clienteService.modificarCliente(idCliente,cliente);
	return null;


}

@DELETE
@Path("{id}")
public void remove(@PathParam("id") Integer id) throws Exception {
	clienteService.eliminar(id);
}

@GET
@Path("/")
public Response listarCliente() throws Exception{
	ArrayList<Cliente> cliente = clienteService.listar();
	return Response.ok(cliente).build();
}

@GET
@Path("{id}")
public Response buscarCliente(@PathParam("id") Integer idCliente) throws Exception{
	Cliente cliente = clienteService.find(idCliente);
	return Response.ok(cliente).build();
}

}
