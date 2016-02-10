/*
 *  {"TipVehCod":0,"TipVehDes":""}
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Vehiculo 
{
    private String codvehiculo;
    private String desvehiculo;
    public static Vehiculo fromJson(String jsonText)
    {
        Vehiculo vehiculo = new Vehiculo();
        try{
        JSONObject json = new JSONObject(jsonText);
        if(json.has("TipVehCod"))
        {
            vehiculo.setCodvehiculo(json.getString("TipVehCod"));
            System.out.print(json.getString("TipVehCod"));
        }
        if(json.has("TipVehDes"))
        {
            vehiculo.setDesvehiculo(json.getString("TipVehDes"));
            System.out.print(json.getString("TipVehDes"));
        }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
        return vehiculo;
    }
    public static Vector fromJsonArray(String jsonArray)
    {
        Vector vectorVehiculo = new Vector();
        try{
            JSONArray array = new JSONArray(jsonArray);
            for(int i=0;i<array.length();i++)
          
            {
                JSONObject json = array.getJSONObject(i);
                Vehiculo vehiculo = Vehiculo.fromJson(json.toString());
                vectorVehiculo.addElement(vehiculo);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
        return vectorVehiculo;
    }
    public String getCodvehiculo()
    {
       return this.codvehiculo;
    }
    public String getDesvehiculo()
    {
        return this.desvehiculo;
    }
    public void setCodvehiculo(String codvehiculo)
    {
        this.codvehiculo = codvehiculo;
    }
    public void setDesvehiculo(String desvehiculo)
    {
        this.desvehiculo = desvehiculo;
    }
}
