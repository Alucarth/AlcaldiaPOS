/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class ListaUsuarios 
{
    private Vector listaUsuarios;
    public ListaUsuarios(String jsonText)
    {
        System.out.println("lista de usuarios "+jsonText);
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("respuesta"))
            {
                JSONObject respuesta = new JSONObject(json.getString("respuesta"));
                if(respuesta.has("RestUsuarios.RestUsuariosItem"))
                {
                    listaUsuarios = Usuarios.fromJsonArray(respuesta.getString("RestUsuarios.RestUsuariosItem"));
                }
                        
            }
           
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
       
    }
    public Vector getUsuarios()
    {
      return this.listaUsuarios;
    }
    
}
