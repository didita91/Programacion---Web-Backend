package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.pol.una.ii.pw.model.Compra;

@Stateless
public class CompraManager extends AbstractManager<Compra>{

	  @PersistenceContext(unitName = "programacionPU")
	  private EntityManager em;

	  @Override
	  protected EntityManager getEntityManager() {
	     return em;
	  }

	  public CompraManager() {
	     super(Compra.class);
	  }

}
