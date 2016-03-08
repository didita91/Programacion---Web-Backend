
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

import py.pol.una.ii.pw.model.Proveedor;
//import py.pol.una.ii.pw.service.ProveedorService;

//@Path("/proveedores")
//public class ProveedorResources {
//	@Inject
//	private ProveedorService proveedorService;
//	
//@POST
//@Path("/creacion")
//public Response crearProveedor(@QueryParam("nombre") String nombre) throws Exception{
//	Proveedor proveedor = new Proveedor();
//	proveedor.setNombre(nombre);
//	proveedorService.crear(proveedor);
//	return Response.ok("Se creo exitosamente").build();
//}
//
//@PUT
//@Path("/modificacion")
//public Response modificarProveedor(@QueryParam("nombre") String nombre,@QueryParam("nombre") String nombreNuevo) throws Exception{
//	//proveedorService.modificar(proveedorActual, proveedorNuevo);
//	return Response.ok("Se modifico exitosamente").build();
//}
//
//@GET
//@Path("/")
//public Response listarProveedor() throws Exception{
//	ArrayList<Proveedor> proveedor = proveedorService.listar();
//	return Response.ok(proveedor).build();
//}
//
//@GET
//@Path("/busqueda")
//public Response buscarProveedor(String proveedorNombre) throws Exception{
//	Proveedor proveedor = proveedorService.buscar(proveedorNombre);
//	return Response.ok(proveedor).build();
//}
//
//@DELETE
//@Path("/eliminacion")
//public Response eliminarProveedor(String proveedorNombre) throws Exception{
//	proveedorService.eliminar(proveedorNombre);
//	return Response.ok("Se elimino exitosamente").build();
//}
//}
