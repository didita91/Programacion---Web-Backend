package py.pol.una.ii.pw.beans;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.validation.ConstraintViolationException;

import py.pol.una.ii.pw.model.Venta;
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VentaDetalleManager  extends AbstractManager<Venta>{

			  @PersistenceContext(unitName = "programacionPU", type=PersistenceContextType.EXTENDED)
			  private EntityManager em;
			  
		
			  @Override
			  protected EntityManager getEntityManager() {
			     return em;
			  }
			
			  public VentaDetalleManager() {
			     super(Venta.class);
			  }
			  

	}

