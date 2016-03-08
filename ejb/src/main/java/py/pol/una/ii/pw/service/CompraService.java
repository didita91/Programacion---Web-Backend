package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.ejb.LocalBean;

import py.pol.una.ii.pw.model.Compra;
@LocalBean
public class CompraService {
	public ArrayList<Compra> compraList = new ArrayList<Compra>();
	
	public void realizarCompra(Compra compra) throws Exception{		
		compraList.add(compra);	
	}
}
