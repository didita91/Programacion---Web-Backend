
package py.pol.una.ii.pw.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Proveedor;
import py.pol.una.ii.pw.service.ProveedorService;

@Path("Proveedors")
public class ProveedorResources {
	@Inject
	private ProveedorService ProveedorService;
	
@POST
@Path("creacion")
public Response crearProveedor(Proveedor Proveedor) throws Exception{
	ProveedorService.crear(Proveedor);
	return Response.ok("Se creo exitosamente").build();
}

@PUT
@Path("modificacion")
public Response modificarProveedor(Proveedor ProveedorActual,Proveedor ProveedorNuevo) throws Exception{
	ProveedorService.modificar(ProveedorActual, ProveedorNuevo);
	return Response.ok("Se modifico exitosamente").build();
}

@GET
@Path("/")
public Response listarProveedor() throws Exception{
	ArrayList<Proveedor> Proveedor = ProveedorService.listar();
	return Response.ok(Proveedor).build();
}

@GET
@Path("busqueda")
public Response buscarProveedor(String ProveedorNombre) throws Exception{
	Proveedor Proveedor = ProveedorService.buscar(ProveedorNombre);
	return Response.ok(Proveedor).build();
}

@POST
@Path("eliminacion")
public Response eliminarProveedor(String ProveedorNombre) throws Exception{
	ProveedorService.eliminar(ProveedorNombre);
	return Response.ok("Se elimino exitosamente").build();
}
}
