package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.service.ClienteService;

@Path("clientes")
public class ClienteResources {
	@Inject
	private ClienteService clienteService;
	
@POST
@Path("creacion")
public Response crearCliente(Cliente cliente) throws Exception{
	clienteService.crear(cliente);
	return Response.ok("Se creo exitosamente").build();
}

@PUT
@Path("modificacion")
public Response modificarCliente(Cliente clienteActual,Cliente clienteNuevo) throws Exception{
	clienteService.modificar(clienteActual, clienteNuevo);
	return Response.ok("Se modifico exitosamente").build();
}

@GET
@Path("/")
public Response listarCliente() throws Exception{
	ArrayList<Cliente> cliente = clienteService.listar();
	return Response.ok(cliente).build();
}

@GET
@Path("busqueda")
public Response buscarCliente(String clienteNombre) throws Exception{
	Cliente cliente = clienteService.buscar(clienteNombre);
	return Response.ok(cliente).build();
}

@POST
@Path("eliminacion")
public Response eliminarCliente(String clienteNombre) throws Exception{
	clienteService.eliminar(clienteNombre);
	return Response.ok("Se elimino exitosamente").build();
}
}
