package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import py.pol.una.ii.pw.model.Compra;

public class CompraService {
	public ArrayList<Compra> compraList = new ArrayList<Compra>();
	// Iterator<Cliente> clienteIterator = clienteList.iterator();
	
	public void realizarCompra(Compra compra) throws Exception{		
		compraList.add(compra);	
	}
}
