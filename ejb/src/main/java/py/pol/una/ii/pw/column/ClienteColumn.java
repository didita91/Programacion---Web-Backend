package py.pol.una.ii.pw.column;

import java.util.HashMap;
import java.util.Map;

public class ClienteColumn {

    private final static Map<String, String> mapColumn = new HashMap<String, String>();

    static {
    	mapColumn.put("idCliente", "id_cliente");
        mapColumn.put("ruc", "RUC");
        mapColumn.put("nombre", "NOMBRE");
        mapColumn.put("saldo", "SALDO");
     

    }

    /**
     *
     * @param nombreAtributo
     * @return nombre del campo de la tabla mapeado al nombre de atributo dado.
     */
    public static String getColumnsName(String nombreAtributo) {
        return mapColumn.get(nombreAtributo);
    }
}
