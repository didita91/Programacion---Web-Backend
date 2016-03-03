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
	
	public void modificar(Producto clienteActual, Producto clienteNuevo) throws Exception{
			
		while(productoIterator.hasNext()) {
			Producto cliente = productoIterator.next();
			if(cliente.equals(clienteActual)){
				cliente = clienteNuevo;
				break;
			}
		}
	}
	
	public void eliminar (String clienteNombre) throws Exception{
		
		int i=0;
		while(productoIterator.hasNext()) {
			Producto c = productoIterator.next();
			if(c.getNombre().equals(clienteNombre)){
				productoList.remove(i);
				break;
			}
			i++;
		}
	}
	
	public Producto buscar (String clienteNombre) throws Exception{
		while(productoIterator.hasNext()) {
			Producto c = productoIterator.next();
			if(c.getNombre().equals(clienteNombre)){
				return c;
			}
		}
		return null;
	}
	
	public ArrayList<Producto> listar () throws Exception{

		return productoList;
	}

}
