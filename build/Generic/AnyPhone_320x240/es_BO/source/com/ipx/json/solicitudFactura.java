/*
 * armando solicitud json al servidor
 * 
 * {
    "client_id": 1,
     "invoice_items": [{
     "product_id": 1,
     "qty": "7.0000"},
      {
     "product_id": 2,
     "qty": "2.0000"},
      {
     "product_id":3,
     "qty": "4.0000"}]
}
* nota el orden de las variables no altera la solicitud jajaja
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class solicitudFactura {

private String client_id;
private Vector productos;

 /**
     * Allows to get the JSON String from the Client passed as parameter
     * @param client Client object to convert to JSON
     * @return JSON String of the Client passed as parameter
     */
    public static String toJSON(solicitudFactura solfac)
    {
        return toJSONObject(solfac).toString();
    }
     /**
     * This method should be used by this class only, that's why it is private.
     * Allows to get a JSONObject from the Client passed as parameter
     * @param client Client Object to convert to JSONObject
     * @return JSONObject representation of the Client passed as parameter
     */
    private static JSONObject toJSONObject(solicitudFactura solfac) {
        JSONObject json = new JSONObject();
        try {
//            json.put("invoice_items",solfac.getProductos() );
            json.put("client_id", solfac.client_id);
            json.put("invoice_items",solfac.getProductos() );
      } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    public void setClient_id(String client_id)
    {
        this.client_id = client_id;
    }
    public void setProductos(Vector productos)
    {
        this.productos = productos;
    }
    public String getClient_id()
    {
        return this.client_id;
    }
    public JSONArray getProductos()
    {
        return Products.toJSONs(this.productos);
    }
    
    
}
