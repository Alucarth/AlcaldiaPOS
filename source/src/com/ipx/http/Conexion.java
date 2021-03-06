/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.http;



import com.ipx.util.Base64;
import com.mobiwire.startup.StartApp;
import de.enough.polish.ui.Form;
import de.enough.polish.ui.Gauge;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 *
 * @author David Torrez Salinas
 */
public class Conexion extends Thread 
{   
//    UsrCod=admin&UsrPwd=adm

    private final String URL_AUTENTIFICACION="http://pos.sigcfactu.com.bo/offline/";
//    private final String URL_AUTENTIFICACION="http://nofunciona.org.zs";
    private final String URL_CONSULTADATOS = "http://pos.sigcfactu.com.bo/offline/";
//    private final String URL_REGISTRARINFRACCION = "http://pos.sigcfactu.com.bo/offline/";
    private final String URL_CONSULTAUSUARIOS = "http://pos.sigcfactu.com.bo/offline/";
    
//    private final String URL_AUTENTIFICACION="http://gamlp.ipxserver.com/funciones.php?funcion=consultalogin&";
////    private final String URL_AUTENTIFICACION="http://nofunciona.org.zs";
//    private final String URL_CONSULTADATOS = "http://gamlp.ipxserver.com/funciones.php?funcion=consultadatos";
    private final String URL_REGISTRARINFRACCION = "http://gamlp.ipxserver.com/funciones.php?funcion=registro";
//    private final String URL_CONSULTAUSUARIOS = "http://gamlp.ipxserver.com/funciones.php?funcion=consultausuarios";
//    
    
    
    private final String URL_CLIENTE="http://recarga.cobra.bo/cliente/";
    private final String URL_GUARDARFACTURA="http://recarga.cobra.bo/guardarFactura";
    private final String URL_VERSION="http://recarga.cobra.bo/version";
    private final String URL_REGISTRARCLIENTE="http://recarga.cobra.bo/registrarCliente";
    private final String URL_PRERECARGA="http://recarga.cobra.bo/ConsultaCliente";
    private final String URL_RECARGA="http://recarga.cobra.bo/RegistarRecargademo";
//    private final String URL_AUTENTIFICACION="http://192.168.200.249/ninja/public/login";
//    private final String URL_CLIENTE="http://192.168.200.249/ninja/public/cliente/";
//    private final String URL_GUARDARFACTURA="http://192.168.200.249/ninja/public/guardarFactura";
//    private final String URL_VERSION="http://192.168.200.249/ninja/public/version";
//    private final String URL_REGISTRARCLIENTE="http://192.168.200.249/ninja/public/registrarCliente";
    private final int AUTENTIFICAZION=0;
    private final int CLIENTE=1;
    private final int GUARDARFACTURA=2;
    private final int VERSION=3;
    private final int REGISTRARCLIENTE=5;
    private final int PRERECARGA=6;
    private final int RECARGA=7;
    private final int CONSULTA=10;
    private final int REGISTRARINFRACCION=11;
    private final int CONSULTAUSUARIOS=12;
    
    private String Respuesta=null;
    protected int respCode=0;
    private int id;
    private String parametros;
    private boolean disponible = false;
//    private Form formGauge;
//    private boolean gauge;

    private String llave;
//    private StartApp midlet;
    private boolean corriendo = true;
    private Rest rest;
//    private switchDisplay sd;
    private boolean sw;
    private Thread t;
    
//    public Conexion(StartApp midlet )
//    {
//        this.midlet = midlet;
//    }
    public Conexion(Rest rest)
    {
        this.rest = rest;
    }

   
    public void EnviarGet(int id, String parametros,String parametrosAutentificacion)
    {
       this.id = id;
       this.parametros = parametros;
       this.llave = parametrosAutentificacion;
//       gauge=false;
    }
    public void EnviarGet(int id, String parametros,String parametrosAutentificacion,Thread t)
    {
       this.id = id;
       this.parametros = parametros;
       this.llave = parametrosAutentificacion;
       this.t = t;

    }
    public void EnviarGet(int id, String parametros,Thread t)
    {
       this.id = id;
       this.parametros = parametros;
//       this.llave = parametrosAutentificacion;
       this.t = t;

    }
    
//    public void EnviarGet(int id, String parametros,String parametrosAutentificacion,Form formGauge)
//    {
//       this.id = id;
//       this.parametros = parametros;
//       this.formGauge = formGauge;
//       this.llave = parametrosAutentificacion;
//       gauge=true;
//       //#style .busyIndicator
//       Gauge busyIndicator = new Gauge( null, false,Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING );
//       formGauge.append(busyIndicator);
//       
//    }
   
   
     public void EnviarPost(int id,String parametros, String parametrosAutentificacion,Thread t)
    {
        this.id = id;
        this.parametros = parametros;
        this.llave = parametrosAutentificacion;
        this.t = t;

    }
    
//      public void EnviarPost(int id,String parametros, String parametrosAutentificacion,Form formGauge)
//    {
//        this.id = id;
//        this.parametros = parametros;
//        this.llave = parametrosAutentificacion;
//        this.formGauge = formGauge;
//        gauge = true;
//        //#style .busyIndicator
//        Gauge busyIndicator = new Gauge( null, false,Gauge.INDEFINITE, Gauge.CONTINUOUS_RUNNING );
//        formGauge.append(busyIndicator);
//              
//    }
    public synchronized void run()
    {
        while(corriendo)
        {
            try{
                wait();
            }catch(InterruptedException e){}
            if(corriendo)
            {   
               
                Enviar();
                rest.setRespuesta(this.Respuesta);
                rest.setCodigoRespuesta(respCode);
//                t.notify();
                t.start();
            }
        }
               
    }  
    public synchronized void Lenvantate()
    {
        notify();
    }
    private synchronized void Enviar()
    {
        Respuesta = "vacio";
        String url="";
        try{
           
             switch(id)
            {
                case -1:
                     url="";
                    break;
                case AUTENTIFICAZION:
                  try{
                    url = URL_AUTENTIFICACION;
                    EnviarRestGet(url+this.parametros);
                  
                     
//                    midlet.setRespuesta(this.Respuesta);
//                    midlet.cambiarPantalla(this.Respuesta);
//                    midlet.getFormLogin().delete(midlet.getFormLogin().size());
                    }catch(IOException e){
                        System.out.println("Error al tratar  recoger los datos ");
                    }
                   
                    break;
                case CLIENTE:
                    url = URL_CLIENTE;
                    EnviarRestGet(url+this.parametros);
                    break;
                case GUARDARFACTURA:
                    url = URL_GUARDARFACTURA;
                    EnviarRestPost(url,parametros);
                    break;
                case VERSION:
                    url=URL_VERSION;
                    EnviarRestGet(url+this.parametros);
                    break;
                case REGISTRARCLIENTE:
                    url = URL_REGISTRARCLIENTE;
                    EnviarRestPost(url,parametros);
                    break;
                case PRERECARGA:
                    url = URL_PRERECARGA;
                    EnviarRestPost(url,parametros);
                    break;
                case RECARGA:
                    url = URL_RECARGA;
                    EnviarRestPost(url,parametros);
                    break;
                case CONSULTA:
                    url=URL_CONSULTADATOS;
                    EnviarRestGet(url);
                    break;
                case REGISTRARINFRACCION:
                    url = URL_REGISTRARINFRACCION;
                    System.out.print("\nURL:"+url+this.parametros);
                    EnviarRestGet(url+this.parametros);
                    break;
                case CONSULTAUSUARIOS:
                    url = URL_CONSULTAUSUARIOS;
                    EnviarRestGet(url);
                    break;
                    
                    
            }
  

        }catch(IOException e)
        {
            e.printStackTrace();

        }
    }
    public void EnviarRestGet(String url) throws IOException
    {
        System.out.println("Usrl get: "+url); 
    HttpConnection httpConn = null;
    InputStream is = null;
    OutputStream os = null;
//    String authorizationHeader= "Basic " + Base64.encode(this.llave);
    try {
      // Open an HTTP Connection object
      httpConn = (HttpConnection)Connector.open(url);

      // Setup HTTP Request
      httpConn.setRequestMethod(HttpConnection.GET);
//      httpConn.setRequestProperty("Authorization",authorizationHeader);
      httpConn.setRequestProperty("User-Agent","Profile/MIDP-1.0 Confirguration/CLDC-1.0");
      
      // This function retrieves the information of this connection
     
      /** Initiate connection and check for the response code. If the
        response code is HTTP_OK then get the content from the target
      **/
       this.respCode = httpConn.getResponseCode();
       System.out.println("\nCodigo de Respues ");
      if (respCode == httpConn.HTTP_OK) {// si se envio correctamente los parametros y la direccion, el servidor responde un codigo 200
        StringBuffer sb = new StringBuffer();
        os = httpConn.openOutputStream();
        is = httpConn.openDataInputStream();
        int chr;
        while ((chr = is.read()) != -1)
          sb.append((char) chr);
        
        Respuesta = convertiraISO(sb.toString());
    
      }
      else {
        System.out.println("Error in opening HTTP Connection. Error#" + respCode);
      }

      } finally {
        if(is!= null)
           is.close();
          if(os != null)
            os.close();
      if(httpConn != null)
            httpConn.close();
    }
    
    }
    
    public void EnviarRestPost(String url,String parametros)  throws IOException
    {
        HttpConnection httpConn = null;
//      String url = "http://localhost:8080/examples/servlet/GetBirthday";
        InputStream is = null;
        OutputStream os = null;
//        String authorizationHeader= "Basic " + Base64.encode(this.llave);
    try {
      // Open an HTTP Connection object
      httpConn = (HttpConnection)Connector.open(url);
      // Setup HTTP Request to POST
      httpConn.setRequestMethod(HttpConnection.POST);

      httpConn.setRequestProperty("User-Agent",
        "Profile/MIDP-1.0 Confirguration/CLDC-1.0");
//      httpConn.setRequestProperty("Accept_Language","en-US");
      //Content-Type is must to pass parameters in POST Request
//      httpConn.setRequestProperty("Authorization",authorizationHeader);
      httpConn.setRequestProperty("Content-Type", "application/json");

      // This function retrieves the information of this connection
//      getConnectionInformation(httpConn);


      os = httpConn.openOutputStream();

      String params;
//   parametros 
      params=parametros;

      os.write(params.getBytes());

      /**Caution: os.flush() is controversial. It may create unexpected behavior
            on certain mobile devices. Try it out for your mobile device **/

      //os.flush();

      // Read Response from the Server

      
      StringBuffer sb = new StringBuffer();
      is = httpConn.openDataInputStream();
      this.respCode = httpConn.getResponseCode();
      if (this.respCode == httpConn.HTTP_OK) {
      int chr;
      while ((chr = is.read()) != -1)
        sb.append((char) chr);

      // Converitmos la respuesta de utf-8 a ISO-8859-1
       Respuesta = convertiraISO(sb.toString());
      
      }
      
      } finally {
        if(is!= null)
           is.close();
          if(os != null)
            os.close();
      if(httpConn != null)
            httpConn.close();
    }
    }
//    public String getRespuesta()
//    {
//        return this.Respuesta;
//    }
//    public int getCodigoRespuesta()
//    {
//        return this.respCode;
//    }
//
//    public synchronized String getRespuesta()
//    {
//        while(!this.disponible)
//        {
//              try{
//                  wait();
//                 }catch(InterruptedException ex){}
//                
//        }
//        notify();
//       return this.Respuesta;
//    }
//    public int getCodigoRespuesta()
//    {
//        while(!this.disponible)
//        {
//              try{
//                  wait();
//                 }catch(InterruptedException ex){}
//                
//        }
//        notify();
//        return this.respCode;
//    }
    public static String convertiraISO(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
  
    /*
     *  Funion utilizada para uso de threads 
     */
//    public boolean getDisponible()
//    {
//        return this.disponible;
//    }
//     public synchronized void poner(char valor){
//     while(disponible){
//        try{
//            wait();
//        }catch(InterruptedException ex){}
//    }
//    contenido=valor;
//    disponible=true;
//    notify();
//  }
}
