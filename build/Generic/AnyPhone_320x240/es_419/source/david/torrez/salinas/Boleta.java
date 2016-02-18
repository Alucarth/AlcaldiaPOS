/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    {
        "placa": "2616LHH",
        "tipo": "VAGONETA",
        "color": "BLANCO",
        "operador": "RADIO TAXI TRANS DIPLOMATICO",
        "ruta": "12",
        "ci": "2049972",
        "conductor": "GERMAN MENDOZA CUSICANQUI",
        "monto_total": 40,
        "infracciones": [
          {
            "inf_codigo": "CT-106",
            "monto": "20"
          },
          {
            "inf_codigo": "CT-114",
            "monto": "20"
          }
        ],
        "correlativo": 1
      }

 */

package david.torrez.salinas;

import java.util.Vector;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Boleta 
{
  private String placa;
  private String tipo;
  private String color;
  private String operador;
  private String ruta;
  private String ci;
  private String conductor;
  private String monto_total;
  private Vector infracciones;
  private String correlativo;

    public static Boleta fromJson(String jsonText)
    {
        Boleta boleta = new Boleta();
        
      try {
          JSONObject json = new JSONObject(jsonText);
          
          if(json.has("placa"))
          {
              boleta.setPlaca(json.getString("placa"));
          }
          if(json.has("tipo"))
          {
              boleta.setTipo(json.getString("tipo"));
              
          }
          if(json.has("color"))
          {
              boleta.setColor(json.getString("color"));
          }
          if(json.has("operador"))
          {
              boleta.setOperador(json.getString("operador"));
          }
          if(json.has("ruta"))
          {
              boleta.setRuta(json.getString("ruta"));
              
          }
          if(json.has("ci"))
          {
              boleta.setCi(json.getString("ci"));
          }
          if(json.has("conductor"))
          {
              boleta.setConductor(json.getString("conductor"));
              
          }
          if(json.has("monto_total"))
          {
              boleta.setMonto_total(json.getString("monto_total"));
          }
          if(json.has("correlativo"))
          {
              boleta.setCorrelativo(json.getString("correlativo"));
          }
          if(json.has("infracciones"))
          {
              boleta.setInfracciones(Infraccion.fromArrayJson(json.getString("infracciones")));
          }
          
      } catch (JSONException ex) {
          ex.printStackTrace();
      }
        
        
        return boleta;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(String monto_total) {
        this.monto_total = monto_total;
    }

    public Vector getInfracciones() {
        return infracciones;
    }

    public void setInfracciones(Vector infracciones) {
        this.infracciones = infracciones;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }
  
  
  
}
