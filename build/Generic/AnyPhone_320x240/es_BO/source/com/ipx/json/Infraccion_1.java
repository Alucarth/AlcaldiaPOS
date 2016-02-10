/*
 * Parametros de envio
 * &Inffch=2014-02-04
 * &Infconci=47715531
 * &Infconciciu=lp
 * &Infconnom=alejandro
 * &Infconapepat=guisbert
 * &Infconapemat=flor
 * &Infvehplan=930
 * &Infvehplal=upn
 * &Inftipvehcod=6
 * &Infcolcodpri=15
 * &Lindes=a
 * &Infviatip=avenida
 * &Infubivia=vasquez
 * &Zoncod=168&
 * Usrcodreg=admin&
 * Subinfcod1=100&
 * Subinfcod2=100&
 * Agrcod=205
 * 
 * Respuesta json
 * "Infnumcom":"100118\/2014","Infmonfin":120
 * 
 */

package com.ipx.json;

import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David
 */
public class Infraccion_1 
{
   private String infnum;
   private String infmonto;
  
   public Infraccion_1(String jsonText)
   {
       try{
           JSONObject json = new JSONObject(jsonText);
           if(json.has("Infnumcom"))
           {
                   infnum = json.getString("Infnumcom");
           }
           if(json.has("Infmonfin"))
           {
               infmonto= json.getString("Infmonfin");
           }
           
       }catch(JSONException e)
       {
           e.printStackTrace();
       }
   }
   public String getNumeroInfraccion()
   {
       return this.infnum;
   }
   public String getMontoInfraccion()
   {
       return this.infmonto;
   }
}
