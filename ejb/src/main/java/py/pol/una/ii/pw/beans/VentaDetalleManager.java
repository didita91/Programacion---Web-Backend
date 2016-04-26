//package py.pol.una.ii.pw.beans;
//
//import javax.ejb.Stateless;
//import javax.ejb.TransactionAttribute;
//import javax.ejb.TransactionAttributeType;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceContextType;
//
//import py.pol.una.ii.pw.model.VentaDetalle;
//@Stateless
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
//public class VentaDetalleManager  extends AbstractManager<VentaDetalle>{
//
//			  @PersistenceContext(unitName = "programacionPU")
//			  private EntityManager em;
//			  
//		
//			  @Override
//			  protected EntityManager getEntityManager() {
//			     return em;
//			  }
//			
//			  public VentaDetalleManager() {
//			     super(VentaDetalle.class);
//			  }
//			
//
////			public void create(VentaDetalle detalle) {
////		
////				     getEntityManager().persist(detalle);
////				    			
////			}
//			  
//
//	}
//
