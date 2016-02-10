/*
 *funciones.php?funcion=registro&Inffch=DATO&Infconci=DATO&Infconciciu=DATO&
                                Infconnom=DATO&Infconapepat=DATO&Infconapemat=DATO&
                                Infvehplan=DATO&Infvehplal=DATO&Inftipvehcod=DATO&
                                Infcolcodpri=DATO&Lindes=DATO&Infviatip=DATO&Infubivia=DATO&
                                Zoncod=DATO&Usrcodreg=DATO&Subinfcod1=DATO&Subinfcod2=DATO&Agrcod=DATO
 */

package com.ipx.json;

/**
 *
 * @author David
 */
public class Inf
{
    private String fecha,ci,cuidad,nombre,apaterno,amaterno,placaNum,placaLit,vehiculo,codColor,lineaDesc,via,calle,codZon,codUser,inf1,inf2,codGrav;
    public String getConsulta()
    {
        String consulta="&Inffch="+this.getFecha()+"&Infconci="+this.getCi()+"&Infconciciu="+this.getCuidad()+
                                "&Infconnom="+this.getNombre()+"&Infconapepat="+this.getApaterno()+"&Infconapemat="+this.getAmaterno()+
                                "&Infvehplan="+this.getPlacaNum()+"&Infvehplal="+this.getPlacaLit()+"&Inftipvehcod="+this.getVehiculo()+
                                "&Infcolcodpri="+this.getCodColor()+"&Lindes="+this.getLineaDesc()+"&Infviatip="+this.getVia()+"&Infubivia="+this.getCalle()+
                                "&Zoncod="+this.getCodZon()+"&Usrcodreg="+this.getCodUser()+"&Subinfcod1="+this.getInf1()+"&Subinfcod2="+this.getInf2()+"&Agrcod="+this.getCodGrav();
        return consulta;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public void setPlacaNum(String placaNum) {
        this.placaNum = placaNum;
    }

    public void setPlacaLit(String placaLit) {
        this.placaLit = placaLit;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setCodColor(String codColor) {
        this.codColor = codColor;
    }

    public void setLineaDesc(String lineaDesc) {
        this.lineaDesc = lineaDesc;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCodZon(String codZon) {
        this.codZon = codZon;
    }

    public void setCodUser(String codUser) {
        this.codUser = codUser;
    }

    public void setInf1(String inf1) {
        this.inf1 = inf1;
    }

    public void setInf2(String inf2) {
        this.inf2 = inf2;
    }

    public void setCodGrav(String codGrav) {
        this.codGrav = codGrav;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCi() {
        return ci;
    }

    public String getCuidad() {
        return cuidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public String getPlacaNum() {
        return placaNum;
    }

    public String getPlacaLit() {
        return placaLit;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public String getCodColor() {
        return codColor;
    }

    public String getLineaDesc() {
        return lineaDesc;
    }

    public String getVia() {
        return via;
    }

    public String getCalle() {
        return calle;
    }

    public String getCodZon() {
        return codZon;
    }

    public String getCodUser() {
        return codUser;
    }

    public String getInf1() {
        return inf1;
    }

    public String getInf2() {
        return inf2;
    }

    public String getCodGrav() {
        return codGrav;
    }
}
