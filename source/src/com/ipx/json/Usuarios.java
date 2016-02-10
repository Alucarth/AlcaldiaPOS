/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.json;

import de.enough.polish.io.Serializable;
import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Usuarios implements Serializable
{
    private String user,password;
    public static Usuarios fromJson(String jsonText)
    {
        Usuarios usuario = new Usuarios();
        try {
            JSONObject json= new JSONObject(jsonText);
            if(json.has("User"))
            {
                usuario.setUser(json.getString("User"));
            }
            if(json.has("Password"))
            {
                usuario.setPassword(json.getString("Password"));
            }
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
                
        return usuario;
    }
    public static Vector fromJsonArray(String jsonArrayText)
    {   
        Vector listaUsuarios= new Vector();
        try {
            JSONArray jsonArray = new JSONArray(jsonArrayText);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject json = jsonArray.getJSONObject(i);
                Usuarios usuario = Usuarios.fromJson(json.toString());
                listaUsuarios.addElement(usuario);
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
                
        return listaUsuarios;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    
    
}
