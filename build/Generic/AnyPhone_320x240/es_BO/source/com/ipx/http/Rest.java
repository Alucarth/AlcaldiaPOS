/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.http;

/**
 *
 * @author David Torrez
 */
public class Rest 
{
    private String respuesta;    
    private int codresp;
    private Thread t;
    public void setCodigoRespuesta(int codresp)
    {
        this.codresp = codresp;
        
    }
    public int getCodigoRespuesta()
    {
        
        return codresp;
        
    }
    public void setRespuesta(String respuesta)
    {
        this.respuesta = respuesta;
//        t.notify();
    }
    public String getRespuesta()
    {
        return this.respuesta;
    }
//    public void setThread(Thread t)
//    {
//        this.t = t;
//    }

}
