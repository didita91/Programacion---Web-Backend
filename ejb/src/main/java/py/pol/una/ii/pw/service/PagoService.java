package py.pol.una.ii.pw.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import py.pol.una.ii.pw.beans.ClienteManager;
import py.pol.una.ii.pw.mapper.ClienteMapper;
import py.pol.una.ii.pw.mapper.PagoMapper;
import py.pol.una.ii.pw.model.Cliente;
import py.pol.una.ii.pw.model.Pago;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;

public class PagoService {

	@Inject
	private ClienteManager clienteManager;


	public void crear(Pago pago) throws Exception {
		try {
			SqlSession session = new ProgramacionSqlSessionFactory()
					.getSqlSession();
			PagoMapper mapper = session.getMapper(PagoMapper.class);
			mapper.insert(pago);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificar( Pago pago) {
			try {
				SqlSession session = new ProgramacionSqlSessionFactory()
						.getSqlSession();
				PagoMapper mapper = session.getMapper(PagoMapper.class);
				mapper.updateByPrimaryKey(pago);
				session.commit();

			} catch (SqlSessionException s) {
				s.printStackTrace();
			}
	}


	
}
