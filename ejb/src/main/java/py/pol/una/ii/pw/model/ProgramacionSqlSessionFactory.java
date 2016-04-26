package py.pol.una.ii.pw.model;

import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Singleton;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@Singleton
public class ProgramacionSqlSessionFactory {
	private SqlSessionFactory factory;

	public ProgramacionSqlSessionFactory() {

	}

	protected String getConfigURI() {
		return "myBatis/configuracion/configuracion.xml";

	}

	public SqlSession getSqlSession() {
		InputStream stream = null;
		try {
			stream = Resources.getResourceAsStream(getConfigURI());

		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(stream);
		return sessionFactory.openSession();
	}
}
