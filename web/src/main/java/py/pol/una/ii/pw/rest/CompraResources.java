package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.service.VentaService;

@Path("venta")
public class CompraResources {
	@Inject
	private VentaService ventaService;
	
	@POST
	@Path("registro")
	public Response registrarVenta(Venta venta) throws Exception{
		ventaService.realizarVenta(venta);
		return Response.ok("Venta registrada").build();
	}

	

}
