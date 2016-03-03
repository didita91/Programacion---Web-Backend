package py.pol.una.ii.pw.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.inject.Inject;

import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Venta;

public class VentaService {
	@Inject
	private ClienteService clienteService;
	
	public ArrayList<Venta> ventaList = new ArrayList<Venta>();
	
	 Iterator<Cliente> clienteIterator = clienteService.clienteList.iterator();
	 
	 public void realizarVenta(Venta venta) throws Exception{		
			ventaList.add(venta);
			while(clienteIterator.hasNext()) {
				Cliente c = clienteIterator.next();
				if(c.equals(venta.getCliente())){
					c.setSaldo(c.getSaldo()+venta.getMonto());
					break;
				}
			}
		}
	
}
