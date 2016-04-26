package py.pol.una.ii.pw.view.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import py.pol.una.ii.pw.model.Producto;
import py.pol.una.ii.pw.view.sqlprovider.ProductoViewSqlProvider;

public interface ProductoViewMapper {
	@Select({ "select id_producto, nombre, precio, stock from producto limit #{cantidad,jdbcType=INTEGER} offset #{inicio,jdbcType=INTEGER} " })
	@Results(value = {
			@Result(column = "id_producto", property = "idProducto", jdbcType = JdbcType.INTEGER),

			@Result(column = "nombre", property = "nombre", jdbcType = JdbcType.VARCHAR),
			@Result(column = "precio", property = "precio", jdbcType = JdbcType.INTEGER),
			@Result(column = "stock", property = "stock", jdbcType = JdbcType.INTEGER)

	})
	List<Producto> listarOrdenada(@Param("inicio") Integer inicio,
			@Param("cantidad") Integer cantidad);
}
