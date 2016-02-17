/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipx.json;

/**
 *
 * @author David Torrez
 */
import org.json.me.JSONException;
import org.json.me.JSONObject;

public class RespuestaJson
{
    private String placa;
    private String chasis;
    private String color;
    private String nombre;
    private String ci;
    private String id;

    public RespuestaJson(String jsonText)
    {
        try{
            JSONObject json = new JSONObject(jsonText);
            if(json.has("ID"))
            {
                id = json.getString("ID");
            }
            if(json.has("PLACA"))
            {
                placa = json.getString("PLACA");
            }
            if(json.has("CHASIS"))
            {
                chasis= json.getString("CHASIS");
                        
            }
            if(json.has("COLOR"))
            {
                color=json.getString("COLOR");
            }
            if(json.has("NOMBRE"))
            {
                nombre = json.getString("NOMBRE");
            }
            if(json.has("CI"))
            {
                ci = json.getString("CI");
            }
        }catch(JSONException ex)
        {
           
        }
    }
    public String getID()
    {
        return this.id;
    }
    public String getPlaca()
    {
        return this.placa;
    }
    public String getChasis()
    {
        return this.chasis;
    }
    public String getColor()
    {
        return this.color;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    public String getCi()
    {
        return this.ci;
    }

}
