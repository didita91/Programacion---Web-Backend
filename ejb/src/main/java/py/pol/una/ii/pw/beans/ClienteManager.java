package py.pol.una.ii.pw.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.pol.una.ii.pw.model.Cliente;
@Stateless
public class ClienteManager extends AbstractManager<Cliente>{
		  @PersistenceContext(unitName = "programacionPU")
		  private EntityManager em;

		  @Override
		  protected EntityManager getEntityManager() {
		     return em;
		  }

		  public ClienteManager() {
		     super(Cliente.class);
		  }

}
