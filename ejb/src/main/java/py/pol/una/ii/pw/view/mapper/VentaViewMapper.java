package py.pol.una.ii.pw.view.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import py.pol.una.ii.pw.view.VentaView;

public interface VentaViewMapper {
	 @Select({
	        "select",
	        "id_venta, fecha, id_cliente, monto,id_producto,cantidad",
	        "from venta v,venta_detalle vd",
	        "where vd.id_venta = #{idVenta,jdbcType=INTEGER}"
	    })
	    @Results({
	        @Result(column="id_venta", property="idVenta", jdbcType=JdbcType.INTEGER, id=true),
	        @Result(column="fecha", property="fecha", jdbcType=JdbcType.DATE),
	        @Result(column="id_cliente", property="idCliente", jdbcType=JdbcType.INTEGER),
	        @Result(column="monto", property="monto", jdbcType=JdbcType.INTEGER),
	        @Result(column="id_producto", property="idProducto", jdbcType=JdbcType.INTEGER),
	        @Result(column="cantidad", property="cantidad", jdbcType=JdbcType.INTEGER)
	    })
	    List<VentaView> obtenerVentas(Integer idVenta);
}
