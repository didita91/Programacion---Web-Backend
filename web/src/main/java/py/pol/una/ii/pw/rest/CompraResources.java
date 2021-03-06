package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import py.pol.una.ii.pw.model.Compra;
import py.pol.una.ii.pw.service.CompraService;

@Path("/compras")
public class CompraResources {
	@Inject
	private CompraService compraService;
	
	@POST
	@Path("/registro")
	public Response registrarCompra(Compra compraDetallada) throws Exception {
	compraService.realizarCompra(compraDetallada);
		return Response.ok(Status.OK).build();
	}

}
