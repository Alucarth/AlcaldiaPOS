/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.torrez.salinas;

import java.util.Vector;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class Usuario 
{
    private String id;
    private String usuario;
    private String password;
    private String nombres;
    private String paterno;
    private String materno;
    private String calle;
    private String zona;
    private Vector infracciones;

    public static Usuario fromJson(String jsonText)
    {
        Usuario usuario = new Usuario();
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("idusuario"))
            {
               usuario.setId(json.getString("idusuario"));
            }
            if(json.has("usuario"))
            {
               usuario.setUsuario(json.getString("usuario"));
            }
            if(json.has("prs_nombres"))
            {
                usuario.setNombres(json.getString("prs_nombres"));
            }
            if(json.has("prs_paterno"))
            {
                usuario.setPaterno(json.getString("prs_paterno"));
            }
            if(json.has("prs_materno"))
            {
                usuario.setMaterno(json.getString("prs_materno"));
            }
            if(json.has("calle"))
            {
                usuario.setCalle(json.getString("calle"));
            }
            if(json.has("zona"))
            {
                usuario.setZona(json.getString("zona"));
            }
            if(json.has("infracciones"))
            {
                usuario.setInfracciones(Infraccion.fromArrayJson(json.getString("infracciones")));
            }
            
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
        
        
        return usuario;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Vector getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(Vector infracciones) {
        this.infracciones = infracciones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toJson()
    {
        JSONObject json= new JSONObject();
        
        try {
            json.put("usuario", this.usuario);
            json.put("password", this.password);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
        return json.toString();
    }
    
}
