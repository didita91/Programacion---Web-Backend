package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Pago;
import py.pol.una.ii.pw.service.PagoService;

@Path("/pago")
public class PagoResources {

	@Inject
	private PagoService pagoService;

	@POST
	@Path("/registro")
	public Response registrarPago(@QueryParam("fecha") String fecha, @QueryParam("monto") String monto, @QueryParam("cliente") String cliente) throws Exception {
		Pago pago = new Pago();
		pago.setCliente(Integer.parseInt(cliente));
		//pago.setFecha(fecha);
		pago.setMonto(Integer.parseInt(monto));
		pagoService.realizarPago(pago);
		return Response.ok("Pago registrado").build();
	}

}
