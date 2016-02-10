/*
Respuesta a a mostrar
 * "Cod_Pago": "12345",
"SaldoMayorista": "50000",
"EstadoError": "N",
"MensajeError": "NULL"

 */

package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Recarga
{
    private String codigoPago, saldo, estado,mensaje;
    public Recarga(String jsonText)
    {
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("Cod_Pago"))
            {
                
                setCodigo( json.getString("Cod_Pago"));
            }
            if(json.has("SaldoMayorista"))
            {
                setSaldo(json.getString("SaldoMayorista"));
            }
            if(json.has("EstadoError"))
            {
                setEstado(json.getString("EstadoError"));
            }
            if(json.has("MensajeError"))
            {
                setMensaje("MensajeError");
                
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
                
    }
    private void setCodigo(String codigo)
    {
        this.codigoPago = codigo;
    }
    private void setSaldo(String saldo)
    {
        this.saldo = saldo;
    }
    private void setEstado(String estado)
    {
        this.estado = estado;
    }
    private void setMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }
    private String getCodigo()
    {
        return this.codigoPago;
    }
    private String getSaldo()
    {
        return this.saldo;
    }
    private String getEstado()
    {
        return this.estado;
    }
    private String getMensaje()
    {
        return this.mensaje;
    }
   
}
