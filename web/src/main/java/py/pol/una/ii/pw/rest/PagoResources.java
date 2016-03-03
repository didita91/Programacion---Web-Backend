package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Pago;
import py.pol.una.ii.pw.service.PagoService;

@Path("pago")
public class PagoResources {

	@Inject
	private PagoService pagoService;

	@POST
	@Path("registro")
	public Response registrarPago(Pago pagoDetalle) throws Exception {
		pagoService.realizarPago(pagoDetalle);
		return Response.ok("Pago registrado").build();
	}

}
