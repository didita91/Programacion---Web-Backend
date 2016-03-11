
package py.pol.una.ii.pw.service;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import py.pol.una.ii.pw.beans.ProveedorManager;
import py.pol.una.ii.pw.model.Proveedor;
@Stateless
public class ProveedorService {
	@EJB
	private ProveedorManager proveedorManager;
	public void crear(Proveedor proveedor) throws Exception {
		proveedorManager.create(proveedor);
	}

	public void modificarProveedor(Integer id, Proveedor entity) {
		proveedorManager.edit(entity);
	}

	public void eliminar(Integer idProveedor) throws Exception {

		proveedorManager.remove(proveedorManager.find(idProveedor));
	}

	public ArrayList<Proveedor> listar() throws Exception {

		return (ArrayList<Proveedor>) proveedorManager.findAll();
	}

	public Proveedor find(Integer id) {
		return proveedorManager.find(id);
	}
	
//	public void crear(Proveedor proveedor) throws Exception{
//		proveedorList.add(proveedor);
//	}
//	
//	public void modificar(Proveedor proveedorActual, Proveedor proveedorNuevo) throws Exception{
//			
//		while(proveedorIterator.hasNext()) {
//			Proveedor proveedor = proveedorIterator.next();
//			if(proveedor.equals(proveedorActual)){
//				proveedor = proveedorNuevo;
//				break;
//			}
//		}
//	}
//	
//	public void eliminar (String proveedorNombre) throws Exception{
//		
//		int i=0;
//		while(proveedorIterator.hasNext()) {
//			Proveedor c = proveedorIterator.next();
//			if(c.getNombre().equals(proveedorNombre)){
//				proveedorList.remove(i);
//				break;
//			}
//			i++;
//		}
//	}
//	
//	public Proveedor buscar (String proveedorNombre) throws Exception{
//		while(proveedorIterator.hasNext()) {
//			Proveedor c = proveedorIterator.next();
//			if(c.getNombre().equals(proveedorNombre)){
//				return c;
//			}
//		}
//		return null;
//	}
//	
//	public ArrayList<Proveedor> listar () throws Exception{
//
//		return proveedorList;
//	}
}
