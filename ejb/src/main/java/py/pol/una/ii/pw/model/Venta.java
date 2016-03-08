package py.pol.una.ii.pw.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name = "venta")
public class Venta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "cliente")
	private int cliente;
	
	@Column(name = "monto")
	private Integer monto;
	
	private ArrayList<VentaDetalle> detalles;

	public Venta(Integer id) {
		super();
		this.id = id;
	
	}
	public Venta(){}

	public Venta(Integer id, Date fecha, int cliente, Integer monto,
			ArrayList<VentaDetalle> detalles) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.monto = monto;
		this.detalles = detalles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int i) {
		this.cliente = i;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}

	public List<VentaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<VentaDetalle> detalles) {
		this.detalles = detalles;
	}


	
	
}
