package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import py.pol.una.ii.pw.model.CantidadVentaException;
import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.service.VentaService;

@Path("/venta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VentaResources {
	@Inject
	private VentaService ventaService;

	@POST
	public Response registrarVenta(Venta ventaDetallada) throws Exception {
		try {
			ventaService.realizarVenta(ventaDetallada);
			return Response.ok(Status.OK).build();

		} catch (Exception e) {
			// throw new CantidadVentaException("No puede ser menor a cero");
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}

}
