package py.pol.una.ii.pw.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.ProgramacionSqlSessionFactory;
import py.pol.una.ii.pw.view.mapper.ProductoViewMapper;
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductoStatefulService {


	public List<Producto> buscarTodo(int inicio,int cantidad) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		try{
			SqlSession session = new ProgramacionSqlSessionFactory().getSqlSession();
			ProductoViewMapper mapper = session.getMapper(ProductoViewMapper.class);
			List<Producto> lista = mapper.listarOrdenada(inicio, cantidad);
			return lista;
		}catch(SqlSessionException s){
			s.printStackTrace();
		}
		return null;
	
	}
}

