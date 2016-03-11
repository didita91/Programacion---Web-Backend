package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import py.pol.una.ii.pw.beans.ClienteManager;
import py.pol.una.ii.pw.model.Cliente;

@Stateless
public class ClienteService {
	@EJB
	private ClienteManager clienteManager;

	public void crear(Cliente cliente) throws Exception {
		clienteManager.create(cliente);
	}

	public void modificarCliente(Integer id, Cliente entity) {
		clienteManager.edit(entity);
	}

	public void eliminar(Integer idCliente) throws Exception {

		clienteManager.remove(clienteManager.find(idCliente));
	}

	public ArrayList<Cliente> listar() throws Exception {

		return (ArrayList<Cliente>) clienteManager.findAll();
	}

	public Cliente find(Integer id) {
		return clienteManager.find(id);
	}

}
