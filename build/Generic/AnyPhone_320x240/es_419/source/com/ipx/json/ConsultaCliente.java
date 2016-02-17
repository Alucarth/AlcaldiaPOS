/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class ConsultaCliente 
{
    private String instancia,codigo;
    
    public void setInstancia(String instancia)
    {
        this.instancia = instancia;
    }
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }
    public String getInstancia()
    {
        return this.instancia;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
     public static String toJSON(ConsultaCliente cc)
    {
        return toJSONObject(cc).toString();
    }
     /**
     * This method should be used by this class only, that's why it is private.
     * Allows to get a JSONObject from the Client passed as parameter
     * @param client Client Object to convert to JSONObject
     * @return JSONObject representation of the Client passed as parameter
     * 
     * {"nit":1234567,"name":"clientepos","phone":70000004,"email":"clientepos@clientepos.com"}
     */
    private static JSONObject toJSONObject(ConsultaCliente cc) {
        JSONObject json = new JSONObject();
        try {
            json.put("instancia", cc.getInstancia());
            json.put("Cod_Negocio",cc.getCodigo());
          
            
      } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return json;
    }
            
}
