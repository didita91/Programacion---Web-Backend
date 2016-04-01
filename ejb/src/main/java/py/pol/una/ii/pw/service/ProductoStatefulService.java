package py.pol.una.ii.pw.service;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;




import py.pol.una.ii.pw.beans.ProductoDuplicadoManager;
import py.pol.una.ii.pw.beans.ProductoManager;
import py.pol.una.ii.pw.model.Producto;
@Stateful
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductoStatefulService {
	@EJB
	private ProductoManager productoManager;
	@EJB
	private ProductoDuplicadoManager productoDuplicadoManager;
	@Resource
	private UserTransaction user;
	@PersistenceContext(unitName = "programacionPU")
	private EntityManager em;
	public List<Producto> buscarTodo(int inicio,int cantidad) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		List<Producto> producto = productoManager.listar(inicio,cantidad);
	
		return producto;
	
	}
}

