package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.pol.una.ii.pw.model.Venta;
@Stateless
public abstract class VentaManager   extends AbstractManager<Venta>{

			  @PersistenceContext(unitName = "primary")
			  private EntityManager em;

			  @Override
			  protected EntityManager getEntityManager() {
			     return em;
			  }

			  public VentaManager() {
			     super(Venta.class);
			  }

	}

