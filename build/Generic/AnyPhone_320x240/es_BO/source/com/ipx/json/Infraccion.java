/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ipx.json;

/**
 *
 * @author David
 */
public class Infraccion 
{
    private String numero;
    private String nomvia;
    private String placa;
    private String operador="";
    private String ruta="";
    private String codinfracion;
    private String codgravamen;
    private String nombreagente;

    public String getNumero() {
        return numero;
    }

    public String getNomvia() {
        return nomvia;
    }

    public String getPlaca() {
        return placa;
    }

    public String getOperador() {
        return operador;
    }

    public String getRuta() {
        return ruta;
    }

    public String getCodinfracion() {
        return codinfracion;
    }

    public String getCodgravamen() {
        return codgravamen;
    }

    public String getNombreagente() {
        return nombreagente;
    }
    

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNomvia(String nomvia) {
        this.nomvia = nomvia;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setCodinfracion(String codinfracion) {
        this.codinfracion = codinfracion;
    }

    public void setCodgravamen(String codgravamen) {
        this.codgravamen = codgravamen;
    }

    public void setNombreagente(String nombreagente) {
        this.nombreagente = nombreagente;
    }
    
    
}
