package py.pol.una.ii.pw.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.service.VentaService;

@Path("/venta")
public class CompraResources {
	@Inject
	private VentaService ventaService;
	
	@POST
	@Path("/registro")
	public Response registrarVenta(@QueryParam("fecha") String fecha,@QueryParam("cliente") String cliente,
			@QueryParam("monto") String monto,@QueryParam("detalles") String detalles) throws Exception{
		Venta venta = new Venta();
		//venta.setIdCliente(Integer.parseInt(cliente));
		venta.setMonto(Integer.parseInt(monto));
		//venta.setDetalles(detalles);
		
		
		//ventaService.realizarVenta(venta);
		return Response.ok("Venta registrada").build();
	}

	

}
