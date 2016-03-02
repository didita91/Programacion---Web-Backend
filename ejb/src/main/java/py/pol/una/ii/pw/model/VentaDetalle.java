package py.pol.una.ii.pw.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "venta_detalle")
public class VentaDetalle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_venta")
	private Integer idVenta;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "producto")
	private Producto producto;

	public VentaDetalle(Integer id) {
		super();
		this.id = id;
	}
	
	public VentaDetalle(Integer id, Integer idVenta, Integer cantidad,
			Producto producto) {
		super();
		this.id = id;
		this.idVenta = idVenta;
		this.cantidad = cantidad;
		this.producto = producto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
}
