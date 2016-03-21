package py.pol.una.ii.pw.service;

import javax.ejb.EJB;
import javax.inject.Inject;

import py.pol.una.ii.pw.beans.ClienteManager;
import py.pol.una.ii.pw.beans.PagoManager;
import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Pago;

public class PagoService {

	@Inject
	private ClienteManager clienteManager;
	@Inject
	private PagoManager pagoManager;

	public void crear(Pago pago) throws Exception {
		
		pagoManager.create(pago);
		//Cliente cm = clienteManager.find(pago.getIdCliente().getIdCliente());
		//cm.setSaldo(cm.getSaldo()-pago.getPago());
		//clienteManager.edit(cm);
	}

	public void modificar(Integer id, Pago entity) {
		pagoManager.edit(entity);
	}


	
}
