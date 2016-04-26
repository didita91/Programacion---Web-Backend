package py.pol.una.ii.pw.view;

import java.util.List;

import py.pol.una.ii.pw.model.Venta;
import py.pol.una.ii.pw.model.VentaDetalle;

public class VentaView {
	private Venta venta;
	private List<VentaDetalle> detalle;
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public List<VentaDetalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<VentaDetalle> detalle) {
		this.detalle = detalle;
	}
	

}
