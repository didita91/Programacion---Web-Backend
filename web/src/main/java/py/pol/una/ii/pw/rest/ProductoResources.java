package py.pol.una.ii.pw.rest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.core.Response.Status;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.service.ProductoService;
import py.pol.una.ii.pw.service.ProductoStatefulService;

@Path("/productos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoResources {
	

	@Inject
	private ProductoService productoService;
	@Inject
	private ProductoStatefulService productoStatefulService;

//	@POST
//	@Path("/creacion")
//	public Response crearProducto(Producto producto) throws Exception {
//		try{
//		productoService.crear(producto);
//		return Response.status(Status.CREATED).build();
//		}catch(Exception e){
//			return Response.status(Status.NOT_ACCEPTABLE).build();
//		}
//	}

	@PUT
	@Path("{id}")
	public Response modificarProducto(@PathParam("id") Integer id, Producto entity)
			throws Exception {

		productoService.modificarProducto(entity);
		return Response.ok().build();
	}

	@GET
	@Path("{id}")
	public Response buscarProducto(@PathParam("id") Integer id)
			throws Exception {
		Producto producto = productoService.obtenerProducto(id);
		return Response.ok(producto).build();
	}

	@GET
	@Path("/")
	public Response listarProducto() throws Exception {
	
		StreamingOutput stream = new StreamingOutput() {		
			@Override
			public void write(OutputStream os) throws IOException,
					WebApplicationException {
				BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(os));
				int total=0;
				try {
					int inicio = 0;
					int cantidad = 100;
					List<Producto> producto= productoStatefulService.buscarTodo(inicio,cantidad);
					bw.write("Lista de Productos: ");
					total= total+producto.size();
					bw.newLine();
					while(!producto.isEmpty()){
						inicio += cantidad;
						for(Producto p : producto){
							bw.write("- "+p.getNombre());
							bw.newLine();
						}
						producto= productoStatefulService.buscarTodo(inicio,cantidad);
						total= total+producto.size();
					}
				}catch(Exception e)
				{;}
				bw.write("Total de Productos: "+total);
				bw.close();
			}
		};
		return Response.ok(stream).build();
	}

	@POST
	@Path("/cargas")
	public Response cargarProducto(List<Producto> productoList) throws Exception {


		productoService.crear(productoList);
		return Response.status(Status.CREATED).build();

	}
}
