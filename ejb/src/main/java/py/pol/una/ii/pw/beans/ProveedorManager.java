package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.pol.una.ii.pw.model.Proveedor;

@Stateless
public class ProveedorManager extends AbstractManager<Proveedor> {

			  @PersistenceContext(unitName = "programacionPU")
			  private EntityManager em;

			  @Override
			  protected EntityManager getEntityManager() {
			     return em;
			  }

			  public ProveedorManager() {
			     super(Proveedor.class);
			  }

	}

