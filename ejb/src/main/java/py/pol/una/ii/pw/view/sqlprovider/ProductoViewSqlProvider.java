package py.pol.una.ii.pw.view.sqlprovider;

import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

public class ProductoViewSqlProvider {
	public String listarOrdenada(Integer inicio, Integer cantidad) {
		SELECT("*");
		FROM("producto");
		
		return SQL();
	}
}
