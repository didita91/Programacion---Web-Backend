package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import py.pol.una.ii.pw.model.Producto;

@Stateless
public class ProductoManager extends AbstractManager<Producto> {
	  @PersistenceContext(unitName = "programacionPU", type=PersistenceContextType.EXTENDED)
	  private EntityManager em;

	  @Override
	  protected EntityManager getEntityManager() {
	     return em;
	  }
	  public Producto findByNombre(String nombre) {
	       Query query = em.createNamedQuery("Producto.findByNombre");
	       query.setParameter("nombre", nombre);
	       return (Producto) query.getSingleResult();
	   }
	  public ProductoManager() {
	     super(Producto.class);
	  }
}
