/*
 * {"respond1":{"Colores":{"SDColores.SDColoresItem":
[{"ColCod":0,"ColDes":""},
{"ColCod":3,"ColDes":"AMARILLO"}
* 
* "respond2":{"Tipos":{"SDTiposVehiculo.SDTiposVehiculoItem":
* [
* {"TipVehCod":0,"TipVehDes":""},
* {"TipVehCod":15,"TipVehDes":"AUTOMOVIL"}
* 
* respond3":{"Zonas":{"RestZonas.RestZonasItem":
[{"ZonCod":643,"ZonDes":"SIN REGISTRAR","ZonEst":"S"},
{"ZonCod":14,"ZonDes":"1 DE MAYO CONSTRUCTORES","ZonEst":"S"},
* 
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class ConsultaDatos 
{
    private Vector VectorColores;
    private Vector VectorVehiculos;
    private Vector VectorZonas;
    public ConsultaDatos(String jsonText)
    {   
        System.out.println("consulta datos: "+jsonText);
        try{
            JSONObject json = new JSONObject(jsonText);
           
            if(json.has("respond1"))
            {
                JSONObject jsoncolores = new JSONObject(json.getString("respond1"));
                if(jsoncolores.has("Colores"))
                {
                    JSONObject jsonsd= new JSONObject(jsoncolores.getString("Colores"));
                    if(jsonsd.has("SDColores.SDColoresItem"))
                    {
                       
                        VectorColores = Colores.fromJsonArray(jsonsd.getString("SDColores.SDColoresItem"));
                    }
                }
            }
            if(json.has("respond2"))
            {
                JSONObject jsonvehiculo = new JSONObject(json.getString("respond2"));
                if(jsonvehiculo.has("Tipos"))
                {
                    JSONObject jsonvec = new JSONObject(jsonvehiculo.getString("Tipos"));
                    if(jsonvec.has("SDTiposVehiculo.SDTiposVehiculoItem"))
                    {
                        VectorVehiculos = Vehiculo.fromJsonArray(jsonvec.getString("SDTiposVehiculo.SDTiposVehiculoItem"));
                       // System.out.print(jsonvec.getString("SDTiposVehiculo.SDTiposVehiculoItem"));
                    }
                }
                        
            }
            /*Descomentar para uso del dispositivo*/
//            respond3":{"Zonas":{"RestZonas.RestZonasItem":
            if(json.has("respond3"))
            {
                JSONObject jsonzona = new JSONObject(json.getString("respond3"));
                if(jsonzona.has("Zonas"))
                {
                    JSONObject jsonzon = new JSONObject(jsonzona.getString("Zonas"));
                    {
                        if(jsonzon.has("RestZonas.RestZonasItem"))
                        {
                            VectorZonas = Zona.fromJsonArrya(jsonzon.getString("RestZonas.RestZonasItem"));
                            System.out.print(jsonzon.getString("RestZonas.RestZonasItem"));
                        }
                    }
                }
            }
            
        }catch(JSONException e)
        {
          e.printStackTrace();
        }
                
    }
    public Vector getVectorColores()
    {
       return this.VectorColores;
    }
    public Vector getVectorVehiculo()
    {
        return this.VectorVehiculos;
    }
    public Vector getVectorZona()
    {
        return this.VectorZonas;
    }
    
}
