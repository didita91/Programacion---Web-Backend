package py.pol.una.ii.pw.service;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import py.pol.una.ii.pw.mapper.CompraMapper;
import py.pol.una.ii.pw.model.Compra;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;

@Stateless
public class CompraService {

	
	
	public void realizarCompra(Compra compra) throws Exception {
			try {
				SqlSession session = new ProgramacionSqlSessionFactory()
						.getSqlSession();
				CompraMapper mapper = session.getMapper(CompraMapper.class);
				mapper.updateByPrimaryKey(compra);
				session.commit();

			} catch (SqlSessionException s) {
				s.printStackTrace();
			}
	}
}
