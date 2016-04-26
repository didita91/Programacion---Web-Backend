package py.pol.una.ii.pw.service;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import py.pol.una.ii.pw.example.ClienteExample;
import py.pol.una.ii.pw.mapper.ClienteMapper;
import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;

@Stateless
public class ClienteService {
	public void crear(Cliente cliente) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ClienteMapper mapper = session.getMapper(ClienteMapper.class);
			mapper.insert(cliente);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarCliente(Cliente cliente) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ClienteMapper mapper = session.getMapper(ClienteMapper.class);
			mapper.updateByPrimaryKey(cliente);
			session.commit();

		} catch (SqlSessionException s) {
			s.printStackTrace();
		}

	}

	public void eliminar(Integer idCliente) throws Exception {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ClienteMapper mapper = session.getMapper(ClienteMapper.class);
			mapper.deleteByPrimaryKey(idCliente);
			session.commit();

		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
	}

	public List<Cliente> listar() throws Exception {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ClienteMapper mapper = session.getMapper(ClienteMapper.class);
			ClienteExample clientExample = new ClienteExample();
			ClienteExample.Criteria clienteCriteria = clientExample
					.createCriteria();
			List<Cliente> lista = mapper.selectByExample(clientExample);
			return lista;
		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
		return null;
	}

	public Cliente obtenerCliente(Integer id) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ClienteMapper mapper = session.getMapper(ClienteMapper.class);
			Cliente cliente = mapper.selectByPrimaryKey(id);
			return cliente;
		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
		return null;

	}
}
