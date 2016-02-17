/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Codigo
{
    private String codigo;
    public Codigo(String jsonText)
    {
        try {
            JSONObject json = new JSONObject(jsonText);
            
            if(json.has("Response"))
            {
               codigo = json.getString("Response");
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
    public String getCodigo()
    {
        return this.codigo;
    }
    
}
