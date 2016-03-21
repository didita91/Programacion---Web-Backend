package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import py.pol.una.ii.pw.model.Pago;
import py.pol.una.ii.pw.service.PagoService;

@Path("/pago")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagoResources {

	@Inject
	private PagoService pagoService;

	@POST
	@Path("/")
	public Response registrarPago(Pago pago) throws Exception {
		pagoService.crear(pago);
		return Response.ok(Status.OK).build();
	}

}
