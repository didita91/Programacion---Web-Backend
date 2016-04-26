//package py.pol.una.ii.pw.beans;
//
//import javax.annotation.Resource;
//import javax.ejb.EJBContext;
//import javax.ejb.EJBTransactionRolledbackException;
//import javax.ejb.Stateless;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceContextType;
//import javax.validation.ConstraintViolationException;
//
//import py.pol.una.ii.pw.model.Venta;
//@Stateless
//public class VentaManager  extends AbstractManager<Venta>{
//
//			  @PersistenceContext(unitName = "programacionPU")
//			  private EntityManager em;
//			  
//			  @Resource
//			  private EJBContext context;
//			  
//			  @Override
//			  protected EntityManager getEntityManager() {
//			     return em;
//			  }
//			 
//			  public VentaManager() {
//			     super(Venta.class);
//			  }
//			  
//
//	}
//
