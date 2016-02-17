/*
 * {"ZonCod":643,"ZonDes":"SIN REGISTRAR","ZonEst":"S"}
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
public class Zona 
{
    private String zoncod;
    private String zondes;
    private String zonest;
    public static Zona fromJson(String jsonText)
    {   
        Zona zona = new Zona();
        try{
            JSONObject json = new JSONObject(jsonText);
            if(json.has("ZonCod"))
            {
                zona.setZoncod(json.getString("ZonCod"));
            }
            if(json.has("ZonDes"))
            {
                zona.setZondes(json.getString("ZonDes"));
            }
            if(json.has("ZonEst"))
            {
                zona.setZonest(json.getString("ZonEst"));
            }
        
        }catch(JSONException e)
        {
        }
        return zona;
    }
    public static Vector fromJsonArrya(String jsonArray)
    {
        Vector vectorZona = new Vector();
        try{
            JSONArray array = new JSONArray(jsonArray);
            for(int i =0; i<array.length();i++)
//            for(int i=0;i<10;i++)
            {
                JSONObject json = array.getJSONObject(i);
                Zona z = Zona.fromJson(json.toString());
                vectorZona.addElement(z);
            }
        }catch(JSONException e){}
        
        
        return vectorZona;
    }
    public void setZoncod(String zoncod)
    {
        this.zoncod = zoncod;
    }
    public void setZondes(String zondes)
    {
        this.zondes = zondes;
    }
    public void setZonest(String zonest)
    {
        this.zonest = zonest;
    }
    public String getZoncod()
    {
        return this.zoncod;
    }
    public String getZondes()
    {
        return this.zondes;
    }
    public String getZonest()
    {
        return this.zonest;
    }
    
}
