/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.torrez.salinas;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 * 
 * resolviendo la siguiente respuesta:
 *  {
"inf_codigo": "CT-101"
}
 */
public class Infraccion {
    private String codigo;
    private String agrabante;
    
    public static Infraccion fromjson(String jsonText)
    {
        Infraccion infraccion = new Infraccion();
        
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("inf_codigo"))
            {
                infraccion.setCodigo(json.getString("inf_codigo"));
            }
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
        
        return infraccion;
    }
    public static Vector fromArrayJson(String jsonArrayText)
    {
        Vector infracciones = new Vector();
        try {
            JSONArray jsonArray = new JSONArray(jsonArrayText);
            for(int i=0;i<jsonArray.length();i++)
            {
                Infraccion infraccion = Infraccion.fromjson(jsonArray.getJSONObject(i).toString());
                infracciones.addElement(infraccion);
                
            }
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
       return infracciones; 
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAgrabante() {
        return agrabante;
    }

    public void setAgrabante(String agrabante) {
        this.agrabante = agrabante;
    }
    
   
}
