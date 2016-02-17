/*
 * {"Usrcod":"admin","Usrpwd":"adm","Nombre":"NILO CONDORI AYALA"}
 */
package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Login 
{
    private String usuario="";
    private String password="";
    private String nombre="";
    public Login(String jsonText)
    {
         try{
             
            JSONObject json = new JSONObject(jsonText);
            if(json.has("Usrcod"))
            {
                usuario=json.getString("Usrcod");
            }
            if(json.has("Usrpwd"))
            {
                password = json.getString("Usrpwd");
            }
            if(json.has("Nombre"))
            {
                nombre= json.getString("Nombre");
            }
            
         }catch(JSONException e)
         {
         
         }
    }
    public String getUsuario()
    {
        return this.usuario;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getNombre()
    {
        return this.nombre;
    }
    
}
