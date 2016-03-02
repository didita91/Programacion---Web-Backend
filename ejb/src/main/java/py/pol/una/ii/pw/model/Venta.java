package py.pol.una.ii.pw.model;


import java.io.Serializable;
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

@Entity
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
	private Cliente cliente;
	
	@Column(name = "monto")
	private Integer monto;
	
	private List<VentaDetalle> detalles;

	public Venta(Integer id) {
		super();
		this.id = id;
	
	}

	public Venta(Integer id, Date fecha, Cliente cliente, Integer monto,
			List<VentaDetalle> detalles) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public void setDetalles(List<VentaDetalle> detalles) {
		this.detalles = detalles;
	}


	
	
}
