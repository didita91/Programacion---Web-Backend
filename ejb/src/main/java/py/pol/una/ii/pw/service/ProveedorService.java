package py.pol.una.ii.pw.service;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import py.pol.una.ii.pw.example.ProveedorExample;
import py.pol.una.ii.pw.mapper.ProveedorMapper;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;
import py.pol.una.ii.pw.model.Proveedor;

@Stateless
public class ProveedorService {
	public void crearProveedor(Proveedor proveedor) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProveedorMapper mapper = session.getMapper(ProveedorMapper.class);
			mapper.insert(proveedor);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarProveedor(Proveedor proveedor) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProveedorMapper mapper = session.getMapper(ProveedorMapper.class);
			mapper.updateByPrimaryKey(proveedor);
			session.commit();

		} catch (SqlSessionException s) {
			s.printStackTrace();
		}

	}

	public void eliminar(Integer idProveedor) throws Exception {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProveedorMapper mapper = session.getMapper(ProveedorMapper.class);
			mapper.deleteByPrimaryKey(idProveedor);
			session.commit();

		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
	}

	public List<Proveedor> listar() throws Exception {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProveedorMapper mapper = session.getMapper(ProveedorMapper.class);
			ProveedorExample provExample = new ProveedorExample();
			ProveedorExample.Criteria provCriteria = provExample
					.createCriteria();
			List<Proveedor> lista = mapper.selectByExample(provExample);
			return lista;
		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
		return null;
	}

	public Proveedor obtenerProveedor(Integer idProveedor) {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			ProveedorMapper mapper = session.getMapper(ProveedorMapper.class);
			Proveedor proveedor = mapper.selectByPrimaryKey(idProveedor);
			return proveedor;
		} catch (SqlSessionException s) {
			s.printStackTrace();
		}
		return null;

	}
}
