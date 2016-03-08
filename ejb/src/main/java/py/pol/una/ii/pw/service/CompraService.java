package py.pol.una.ii.pw.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.pol.una.ii.pw.beans.CompraManager;
import py.pol.una.ii.pw.model.Compra;

@Stateless
public class CompraService {

	@Inject
	private CompraManager compraManager;
	
	public void realizarCompra(Compra compra) throws Exception {
		compraManager.create(compra);
	}
}
