package py.pol.una.ii.pw.service;

import java.util.ArrayList;
import java.util.Iterator;

import py.pol.una.ii.pw.model.Producto;

public class ProductoService {
	public ArrayList<Producto> productoList = new ArrayList<Producto>();
	public Iterator<Producto> productoIterator = productoList.iterator();

	public void crear(Producto producto) throws Exception{
		productoList.add(producto);
	}
	
	public void modificar(Producto productoActual, Producto productoNuevo) throws Exception{
			
		while(productoIterator.hasNext()) {
			Producto producto = productoIterator.next();
			if(producto.equals(productoActual)){
				producto = productoNuevo;
				break;
			}
		}
	}
	
	public void eliminar (String productoNombre) throws Exception{
		
		int i=0;
		while(productoIterator.hasNext()) {
			Producto c = productoIterator.next();
			if(c.getNombre().equals(productoNombre)){
				productoList.remove(i);
				break;
			}
			i++;
		}
	}
	
	public Producto buscar (String productoNombre) throws Exception{
		while(productoIterator.hasNext()) {
			Producto c = productoIterator.next();
			if(c.getNombre().equals(productoNombre)){
				return c;
			}
		}
		return null;
	}
	
	public ArrayList<Producto> listar () throws Exception{

		return productoList;
	}

}
