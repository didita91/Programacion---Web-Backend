package py.pol.una.ii.pw.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

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
	  public ProductoDuplicado findByIdProducto(Producto producto) {
	       Query query = em.createNamedQuery("ProductoDuplicado.findByIdProducto");
	       query.setParameter("idProducto", producto);
	       List results = query.getResultList();
	       ProductoDuplicado p= new ProductoDuplicado();
	       if(!results.isEmpty()){
	    	    p = (ProductoDuplicado) results.get(0);
	       }
	       return p;
	   }
	  public ProductoDuplicadoManager() {
	     super(ProductoDuplicado.class);
	  }
}
