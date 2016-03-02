package entity;

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

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "saldo")
	private Integer saldo;	//se suma cuando se produce una venta y se resta cuando se produce un Pago
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Collection<Pago> pagoCollection;
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Collection<Venta> ventaCollection;
	
	public Cliente(Integer id, String nombre, String ruc, Integer saldo,
			Collection<Pago> pagoCollection, Collection<Venta> ventaCollection) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ruc = ruc;
		this.saldo = saldo;
		this.pagoCollection = pagoCollection;
		this.ventaCollection = ventaCollection;
	}

	public Cliente(Integer id) {
		super();
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Collection<Pago> getPagoCollection() {
		return pagoCollection;
	}

	public void setPagoCollection(Collection<Pago> pagoCollection) {
		this.pagoCollection = pagoCollection;
	}

	public Collection<Venta> getVentaCollection() {
		return ventaCollection;
	}

	public void setVentaCollection(Collection<Venta> ventaCollection) {
		this.ventaCollection = ventaCollection;
	}
	
	
	
	
	
	
}
