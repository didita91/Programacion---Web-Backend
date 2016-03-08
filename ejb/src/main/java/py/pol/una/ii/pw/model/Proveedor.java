package py.pol.una.ii.pw.model;



import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "proveedor")
public class Proveedor implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
	private Collection<Compra> compraCollection;

	public Proveedor(Integer id, String nombre,
			Collection<Compra> compraCollection) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compraCollection = compraCollection;
	}

	public Proveedor(Integer id) {
		super();
		this.id = id;
	}
	public Proveedor(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Compra> getCompraCollection() {
		return compraCollection;
	}

	public void setCompraCollection(Collection<Compra> compraCollection) {
		this.compraCollection = compraCollection;
	}
			
}
