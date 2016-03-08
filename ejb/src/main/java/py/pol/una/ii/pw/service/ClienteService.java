package py.pol.una.ii.pw.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.pol.una.ii.pw.beans.ClienteManager;
import py.pol.una.ii.pw.model.Cliente;
@Stateless
public class ClienteService {
	@Inject
	private ClienteManager clienteManager;
	
	//public static final ArrayList<Cliente> clienteList = null;
	//public static final Iterator<Cliente> clienteIterator = clienteList
			//.iterator();

	public void crear(Cliente cliente) throws Exception {
		clienteManager.create(cliente);
	}

	/*public void modificar(Cliente clienteActual, Cliente clienteNuevo)
			throws Exception {

		while (clienteIterator.hasNext()) {
			Cliente cliente = clienteIterator.next();
			if (cliente.equals(clienteActual)) {
				cliente = clienteNuevo;
				break;
			}
		}
	}

	public void eliminar(String clienteNombre) throws Exception {

		int i = 0;
		while (clienteIterator.hasNext()) {
			Cliente c = clienteIterator.next();
			if (c.getNombre().equals(clienteNombre)) {
				clienteList.remove(i);
				break;
			}
			i++;
		}
	}

	public Cliente buscar(String clienteNombre) throws Exception {
		while (clienteIterator.hasNext()) {
			Cliente c = clienteIterator.next();
			if (c.getNombre().equals(clienteNombre)) {
				return c;
			}
		}
		return null;
	}

	public ArrayList<Cliente> listar() throws Exception {

		return clienteList;
	}*/
}
