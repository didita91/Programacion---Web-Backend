package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.inject.Inject;

import py.pol.una.ii.pw.beans.PagoManager;
import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Pago;

public class PagoService {
	@Inject
	private PagoService pagoService;
	
	@Inject
	private PagoManager pagoManager;

	public void crear(Pago pago) throws Exception {
		pagoManager.create(pago);
	}

	public void modificar(Integer id, Pago entity) {
		pagoManager.edit(entity);
	}


	
}
