/*
 * {
    "RazonSocial": "GUISBERT",
    "Nit": "4771553",
    "MensajePromo": "",
    "Saldo": "500",
    "EstadoError": "N",
    "MensajeError": "NULL",
    "TipoCobro": "PRE_PAGO",
    "DescripcionTipoCobro": "",
    "MontoMinimo": "5"
   }
 */
package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class Cliente 
{
    private String resultado;
    private Clients cliente;
    
    private String razonsocial,nit,montominimo;
    
    
    public Cliente(String jsonText)
    {
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("RazonSocial"))
            {
                 razonsocial = json.getString("RazonSocial");
            }
            if(json.has("Nit"))
            {
                nit = json.getString("Nit");
            }
            if(json.has("MontoMinimo"))
            {
                montominimo = json.getString("MontoMinimo");
            }
     
          
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
                
    }
//    public String getResultado()
//    {
//        return this.resultado;
//    }
//    public Clients getCliente()
//    {
//        return this.cliente;
//    }
    public String getRazonSocial()
    {
        return this.razonsocial;
    }
    public String getNit()
    {
        return this.nit;
    }
    public String getMontoMinimo()
    {
        return this.montominimo;
    }
}
