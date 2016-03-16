/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.pol.una.ii.pw.model;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "producto_duplicado")
public class ProductoDuplicado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto_duplicado")
    private Integer id_producto_duplicado;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;
    @Column(name = "cantidad")
    private Integer cantidad;
 

    public ProductoDuplicado() {
    	this.cantidad=0;
    }




    public Producto getProducto() {
		return idProducto;
	}




	public void setProducto(Producto nombre) {
		this.idProducto = nombre;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public Integer getId_producto_duplicado() {
		return id_producto_duplicado;
	}




	public void setId_producto_duplicado(Integer id_producto_duplicado) {
		this.id_producto_duplicado = id_producto_duplicado;
	}




	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoDuplicado)) {
            return false;
        }
        ProductoDuplicado other = (ProductoDuplicado) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tarea2.Producto[ nombre=" + idProducto.getNombre() + " ]";
    }
    
}
