/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class Colores 
{
    private String codcol;
    private String coldes;
    public static Colores fromJson(String jsonText)
    {
        Colores colores= new Colores();
        try{
            JSONObject json = new JSONObject(jsonText);
            if(json.has("ColCod"))
            {
                colores.setCodcol(json.getString("ColCod"));
                
            }
            if(json.has("ColDes"))
            {
                colores.setColdes(json.getString("ColDes"));
            }
        }catch(JSONException e )
        {
            e.printStackTrace();
        }
        return colores;
    }
    public static Vector fromJsonArray(String jsonArray)
    {
        Vector vectorColor = new Vector();
        try{
            JSONArray array= new JSONArray(jsonArray);
            for(int i=0;i<array.length();i++)
            {
                JSONObject json = array.getJSONObject(i);
                Colores col=Colores.fromJson(json.toString());
                vectorColor.addElement(col);
            }
                    
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
        return vectorColor;
    }
    public String getCodcol()
    {
        return this.codcol;
    }
    public String getColdes()
    {
        return this.coldes;
    }
    public void setCodcol(String codcol)
    {
        this.codcol = codcol;
    }
    public void setColdes(String coldes)
    {
        this.coldes = coldes;
    }
}
