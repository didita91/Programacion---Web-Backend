package py.pol.una.ii.pw.sqlprovider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.List;
import java.util.Map;

import py.pol.una.ii.pw.example.DetallecompraExample;
import py.pol.una.ii.pw.example.DetallecompraExample.Criteria;
import py.pol.una.ii.pw.example.DetallecompraExample.Criterion;
import py.pol.una.ii.pw.model.Detallecompra;

public class DetallecompraSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String countByExample(DetallecompraExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("detallecompra");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String deleteByExample(DetallecompraExample example) {
        BEGIN();
        DELETE_FROM("detallecompra");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String insertSelective(Detallecompra record) {
        BEGIN();
        INSERT_INTO("detallecompra");
        
        if (record.getIdCompraDetalle() != null) {
            VALUES("id_compra_detalle", "#{idCompraDetalle,jdbcType=INTEGER}");
        }
        
        if (record.getIdCompra() != null) {
            VALUES("id_compra", "#{idCompra,jdbcType=INTEGER}");
        }
        
        if (record.getIdProducto() != null) {
            VALUES("id_producto", "#{idProducto,jdbcType=INTEGER}");
        }
        
        if (record.getCantidad() != null) {
            VALUES("cantidad", "#{cantidad,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String selectByExample(DetallecompraExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id_compra_detalle");
        } else {
            SELECT("id_compra_detalle");
        }
        SELECT("id_compra");
        SELECT("id_producto");
        SELECT("cantidad");
        FROM("detallecompra");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        Detallecompra record = (Detallecompra) parameter.get("record");
        DetallecompraExample example = (DetallecompraExample) parameter.get("example");
        
        BEGIN();
        UPDATE("detallecompra");
        
        if (record.getIdCompraDetalle() != null) {
            SET("id_compra_detalle = #{record.idCompraDetalle,jdbcType=INTEGER}");
        }
        
        if (record.getIdCompra() != null) {
            SET("id_compra = #{record.idCompra,jdbcType=INTEGER}");
        }
        
        if (record.getIdProducto() != null) {
            SET("id_producto = #{record.idProducto,jdbcType=INTEGER}");
        }
        
        if (record.getCantidad() != null) {
            SET("cantidad = #{record.cantidad,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("detallecompra");
        
        SET("id_compra_detalle = #{record.idCompraDetalle,jdbcType=INTEGER}");
        SET("id_compra = #{record.idCompra,jdbcType=INTEGER}");
        SET("id_producto = #{record.idProducto,jdbcType=INTEGER}");
        SET("cantidad = #{record.cantidad,jdbcType=INTEGER}");
        
        DetallecompraExample example = (DetallecompraExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    public String updateByPrimaryKeySelective(Detallecompra record) {
        BEGIN();
        UPDATE("detallecompra");
        
        if (record.getIdCompra() != null) {
            SET("id_compra = #{idCompra,jdbcType=INTEGER}");
        }
        
        if (record.getIdProducto() != null) {
            SET("id_producto = #{idProducto,jdbcType=INTEGER}");
        }
        
        if (record.getCantidad() != null) {
            SET("cantidad = #{cantidad,jdbcType=INTEGER}");
        }
        
        WHERE("id_compra_detalle = #{idCompraDetalle,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.compra_detalle
     *
     * @mbggenerated Sat Apr 23 22:10:07 PYT 2016
     */
    protected void applyWhere(DetallecompraExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}