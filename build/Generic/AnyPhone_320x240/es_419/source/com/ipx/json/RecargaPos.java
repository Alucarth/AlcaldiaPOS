/*
 * http://recarga.cobra.bo/RegistarRecargademo
{ "Instancia":"72030144", "Monto":"10", "RazonSocial":"GUISBERTRE", "Nit":"4771553", "Cod_Negocio":"104"}
 */

package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez Salinas.
 */
public class RecargaPos 

{
    private String instancia,monto,razonsocial,nit,codigo;
    
    public static String toJSON(RecargaPos rp)
    {
        return toJSONObject(rp).toString();
    }
     /**
     * This method should be used by this class only, that's why it is private.
     * Allows to get a JSONObject from the Client passed as parameter
     * @param client Client Object to convert to JSONObject
     * @return JSONObject representation of the Client passed as parameter
     * 
    
     */
    private static JSONObject toJSONObject(RecargaPos rp) {
        JSONObject json = new JSONObject();
        try {
           
            json.put("Instancia",rp.getInstancia());
            json.put("Monto", rp.getMonto());
            json.put("RazonSocial", rp.getRazonSocial());
            json.put("Nit", rp.getNit());
            json.put("Cod_Negocio",rp.getCodigo());
          
            
      }catch (JSONException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
    public void setInstancia(String instancia)
    {
        this.instancia = instancia;
    }
//    public void setId(String id)
//    {
//        this.id =id ;
//    }
    public void setMonto(String monto)
    {
        this.monto = monto;
    }
    public void setRazonSocial(String razonsocial)
    {
        this.razonsocial=razonsocial;
    }
    public void setNit(String nit)
    {
        this.nit = nit;
              
    }
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }
//    public String getId()
//    {
//        return this.id;
//    }
    public String getInstancia()
    {
        return this.instancia;
    }
    public String getMonto()
    {
        return this.monto;
    }
    public String getRazonSocial()
    {
        return this.razonsocial;
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    public String getNit()
    {
        return this.nit;
    }
}
