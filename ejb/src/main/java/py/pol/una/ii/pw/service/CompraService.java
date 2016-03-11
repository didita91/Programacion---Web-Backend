package py.pol.una.ii.pw.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import py.pol.una.ii.pw.beans.CompraManager;
import py.pol.una.ii.pw.model.Compra;

@Stateless
public class CompraService {

	@EJB
	private CompraManager compraManager;
	
	public void realizarCompra(Compra compra) throws Exception {
		compraManager.create(compra);
	}
}
