
package py.pol.una.ii.pw.service;

import java.util.ArrayList;
import java.util.Iterator;

import py.pol.una.ii.pw.model.Proveedor;

public class ProveedorService {

	public ArrayList<Proveedor> proveedorList = new ArrayList<Proveedor>();
	public Iterator<Proveedor> proveedorIterator = proveedorList.iterator();
	
	
	public void crear(Proveedor proveedor) throws Exception{
		proveedorList.add(proveedor);
	}
	
	public void modificar(Proveedor proveedorActual, Proveedor proveedorNuevo) throws Exception{
			
		while(proveedorIterator.hasNext()) {
			Proveedor proveedor = proveedorIterator.next();
			if(proveedor.equals(proveedorActual)){
				proveedor = proveedorNuevo;
				break;
			}
		}
	}
	
	public void eliminar (String proveedorNombre) throws Exception{
		
		int i=0;
		while(proveedorIterator.hasNext()) {
			Proveedor c = proveedorIterator.next();
			if(c.getNombre().equals(proveedorNombre)){
				proveedorList.remove(i);
				break;
			}
			i++;
		}
	}
	
	public Proveedor buscar (String proveedorNombre) throws Exception{
		while(proveedorIterator.hasNext()) {
			Proveedor c = proveedorIterator.next();
			if(c.getNombre().equals(proveedorNombre)){
				return c;
			}
		}
		return null;
	}
	
	public ArrayList<Proveedor> listar () throws Exception{

		return proveedorList;
	}
}
