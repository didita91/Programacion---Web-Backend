package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
public void crearCliente(@QueryParam("nombre") String nombre,@QueryParam("ruc") String ruc, @QueryParam("saldo") String saldo) throws Exception{
	Cliente cliente = new Cliente();
	cliente.setNombre(nombre);
	cliente.setRuc(ruc);
	cliente.setSaldo(Integer.parseInt(saldo));
	clienteService.crear(cliente);
	//return Response.ok("Se creo exitosamente").build();
}

@PUT
@Path("/modificacion")
public Response modificarCliente(@QueryParam("nombre") String nombre,@QueryParam("ruc") String ruc, @QueryParam("saldo") String saldo,@QueryParam("nombre") String nombreNuevo,@QueryParam("ruc") String rucNuevo, @QueryParam("saldo") String saldoNuevo) throws Exception{
	Cliente clienteActual = new Cliente();
	clienteActual.setNombre(nombre);
	clienteActual.setRuc(ruc);
	clienteActual.setSaldo(Integer.parseInt(saldo));
	Cliente clienteNuevo= new Cliente();
	clienteNuevo.setNombre(nombreNuevo);
	clienteNuevo.setRuc(rucNuevo);
	clienteNuevo.setSaldo(Integer.parseInt(saldo));
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
@Path("/busqueda")
public Response buscarCliente(@QueryParam("clienteNombre") String clienteNombre) throws Exception{
	Cliente cliente = clienteService.buscar(clienteNombre);
	return Response.ok(cliente).build();
}

@DELETE
@Path("/eliminacion")
public Response eliminarCliente(@QueryParam("clienteNombre") String clienteNombre) throws Exception{
	clienteService.eliminar(clienteNombre);
	return Response.ok("Se elimino exitosamente").build();
}
}
