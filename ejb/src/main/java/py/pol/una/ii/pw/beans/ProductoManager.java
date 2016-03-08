package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.pol.una.ii.pw.model.Producto;

@Stateless
public abstract class ProductoManager extends AbstractManager<Producto> {
	 @PersistenceContext(unitName = "primary")
	  private EntityManager em;

	  @Override
	  protected EntityManager getEntityManager() {
	     return em;
	  }

	  public ProductoManager() {
	     super(Producto.class);
	  }
}
