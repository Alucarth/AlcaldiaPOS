/*
 * Clase que trata la respuesta json
 * "invoice_number": "0012",
    "control_code": "D5-BE-A6-00",
    * "invoice_date": "2014-04-17"
    * "amount": "140.0000",
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class Factura 
{
    private String invoice_number;
    private String control_code;
    private String invoice_date;
    private String amount;
    //falta cliente, cuenta y invoice items
    private Account account;
    private Vector items;
    private Clients cliente;
    private Recarga recarga;
    public Factura(String jsonText)
    {
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("invoice_number"))
            {
                invoice_number=json.getString("invoice_number");
            }
            if(json.has("control_code"))
            {
                control_code = json.getString("control_code");
            }
            if(json.has("invoice_date"))
            {
                invoice_date = json.getString("invoice_date");
            }
            if(json.has("amount"))
            {
                amount = json.getString("amount");
            }
            if(json.has("client"))
            {
                cliente = Clients.fromJson(json.getString("client"));
            }
            if(json.has("account"))
            {
                account = new Account(json.getString("account"));
                               
            }
            if(json.has("invoice_items"))
            {
                items = InvoiceItems.fromJsonArray(json.getString("invoice_items"));
            }
            if(json.has("Recarga"))
            {
                recarga = new Recarga(json.getString("Recarga"));
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
    }
    public String getInvoiceNumber()
    {
        return this.invoice_number;
    }
    public String getControlCode()
    {
        return this.control_code;
    }
    public String getInvoiceDate()
    {
        return this.invoice_date;
    }
    public String getAmount()
    {
        return this.amount;
    }
    public Account getAccount()
    {
        return this.account;
    }
    public Vector getInvoiceItems()
    {
        return this.items;
    }
    public Clients getCliente()
    {
        return  this.cliente;
    }
    public Recarga getRecarga()
    {
        return this.recarga;
    }
}
