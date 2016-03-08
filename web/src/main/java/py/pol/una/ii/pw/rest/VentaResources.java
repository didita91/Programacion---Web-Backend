package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.service.VentaService;

@Path("/compra-producto")
public class VentaResources {
	@Inject
	private VentaService ventaService;

	@POST
	@Path("/registro")
	public Response registrarCompra(Venta ventaDetallada) throws Exception {
	ventaService.crear(ventaDetallada);
		return Response.ok("Compra registrada").build();
	}

}
