/*
 * {
        "id": 1,
        "name": "Pollos Copacabana",
        "nit": "987654321"
   }
 */
package com.ipx.json;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author David Torrez
 */
public class Clients
{
    private String id;
    private String name;
    private String nit;
    
    public static Clients fromJson(String jsonText)
    {
        Clients client = new Clients();
        try {
            JSONObject json =new  JSONObject(jsonText);
            if(json.has("id"))
            {
                client.setId(json.getString("id"));
            }
            if(json.has("name"))
            {
                client.setName(json.getString("name"));
            }
            if(json.has("nit"))
            {
                client.setNit(json.getString("nit"));
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        
        return client;
    }
    public static Vector fromJsonArray(String jsonArray)
    {
        Vector vectorClients = new Vector();
        try{
            JSONArray array = new JSONArray(jsonArray);
            for(int i=0;i<array.length();i++)
            {
                JSONObject json = array.getJSONObject(i);
                Clients client = Clients.fromJson(json.toString());
                vectorClients.addElement(client);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
        return vectorClients;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setNit(String nit)
    {
        this.nit = nit;
    }
    public String getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public String getNit()
    {
        return this.nit;
    }
}
