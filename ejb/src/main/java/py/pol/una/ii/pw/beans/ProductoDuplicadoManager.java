package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.model.ProductoDuplicado;

@Stateless
public class ProductoDuplicadoManager extends AbstractManager<ProductoDuplicado> {
	  @PersistenceContext(unitName = "programacionPU", type=PersistenceContextType.EXTENDED)
	  private EntityManager em;

	  @Override
	  protected EntityManager getEntityManager() {
	     return em;
	  }

	  public ProductoDuplicadoManager() {
	     super(ProductoDuplicado.class);
	  }
}
