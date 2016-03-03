package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Compra;
import py.pol.una.ii.pw.service.CompraService;

@Path("compra-producto")
public class VentaResources {
	@Inject
	private CompraService compraService;

	@POST
	@Path("registro")
	public Response registrarCompra(Compra compraDetallada) throws Exception {
		compraService.realizarCompra(compraDetallada);
		return Response.ok("Compra registrada").build();
	}

}
