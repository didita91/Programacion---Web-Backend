package py.pol.una.ii.pw.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import py.pol.una.ii.pw.model.Producto;

@Stateless
public class ProductoManager extends AbstractManager<Producto> {
	@PersistenceContext(unitName = "programacionPU")
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

//	public List<Producto> buscarTodo() {
//		int inicio = 0;
//		int cantidad = 2;
//		List<Producto> lista = listar(inicio, cantidad);
//		List<Producto> aux= new ArrayList<Producto>();
//		while (lista.size() != 0) {
//			for(Producto p: lista){
//				aux.add(p);
//			}
//			inicio += cantidad;
//			lista = listar(inicio, cantidad);
//			
//		}
//		return aux;
//	}

	public List<Producto> listar(int inicio,int cantidad) {
		String consulta = "SELECT * FROM PRODUCTO";
		Query query = em.createNamedQuery("Producto.findAll");
		query.setMaxResults(100);
		query.setFirstResult(inicio);
		query.setMaxResults(cantidad);
		List<Producto> lista = query.getResultList();
		return lista;
	}

	public ProductoManager() {
		super(Producto.class);
	}
}
