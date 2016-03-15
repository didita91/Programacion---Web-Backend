package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.service.VentaService;

@Path("/compra-producto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VentaResources {
	@Inject
	private VentaService ventaService;

	@POST
	@Path("/registro")
	public Response registrarVenta(Venta ventaDetallada) throws Exception {
	ventaService.realizarVenta(ventaDetallada);
		return Response.ok("Venta registrada").build();
	}

}
