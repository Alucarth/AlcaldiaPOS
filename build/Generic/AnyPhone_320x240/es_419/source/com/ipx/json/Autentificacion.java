/*
 * {"Usrcod":"admin","Usrpwd":"adm","Nombre":"NILO CONDORI AYALA"}
nota solo interesa el nombre 
 */

package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Autentificacion 
{
    private String usrcod,usrpwd,nombre;

    public void setUsrcod(String usrcod) {
        this.usrcod = usrcod;
    }

    public void setUsrpwd(String usrpwd) {
        this.usrpwd = usrpwd;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Autentificacion()
    {
        
    }
    public  Autentificacion(String jsonText)
    {
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("Usrcod"))
            {
                usrcod = json.getString("Usrcod");
             
            }
            if(json.has("Usrpwd"))
            {
                usrpwd=json.getString("Usrpwd");
                
            }
            if(json.has("Nombre"))
            {
                nombre= json.getString("Nombre");
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
                
    
    }
    public String getUserCod()
    {
        return this.usrcod;
    }
    public String getUserPass()
    {
        return this.usrpwd;
    }
    public String getNombre()
    {
        return this.nombre;
    }
}
