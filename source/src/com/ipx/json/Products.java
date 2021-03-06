/*
 * {
        "id": 1,
        "notes": "Servicios",
        "cost": "253.4000"
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
public class Products 
{
    private String id;
    private String notes;
    private String cost;
    private String qty;
    public static Products fromJson(String jsonText)
    {
        Products product = new Products();
        try {
            JSONObject json = new JSONObject(jsonText);
            if(json.has("id"))
            {
                product.setId(json.getString("id"));
            }
            if(json.has("notes"))
            {
                product.setNotes(json.getString("notes"));
            }
            if(json.has("cost"))
            {
                product.setCost(json.getString("cost"));
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return product;
    }
    public static Vector fromJsonArray(String jsonArray)
    {
        Vector vectorProducts = new Vector();
        try{
            JSONArray array = new JSONArray(jsonArray);
            for(int i=0;i<array.length();i++)
            {
                JSONObject json = array.getJSONObject(i);
                Products product = Products.fromJson(json.toString());
                vectorProducts.addElement(product);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }
        return vectorProducts;
    }
    //armando solicitud de usuario a cliente
      /**
     * Allows to get the JSON String from the Client passed as parameter
     * @param client Client object to convert to JSON
     * @return JSON String of the Client passed as parameter
     */
    public static String toJSON(Products producto)
    {
        return toJSONObject(producto).toString();
    }
     /**
     * This method should be used by this class only, that's why it is private.
     * Allows to get a JSONObject from the Client passed as parameter
     * @param client Client Object to convert to JSONObject
     * @return JSONObject representation of the Client passed as parameter
     */
    private static JSONObject toJSONObject(Products producto) {
        JSONObject json = new JSONObject();
        try {
            json.put("id", producto.getId());
            json.put("qty",producto.getQty() );
      } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return json;
    }
    
     /**
     * Allows to get JSON String from a Vector of Clients
     * @param clients Vector of clients to convert to JSON
     * @return JSON String of the Vector of clients
     */
    public static JSONArray toJSONs(Vector products) {
        JSONArray productsArray = new JSONArray();
        for (int i = 0; i < products.size(); i++) {
            Products producto = (Products)products.elementAt(i);

            JSONObject jsonObject = toJSONObject(producto);
            productsArray.put(jsonObject);
        }
//        return productsArray.toString();
        return productsArray;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    public void setNotes(String notes)
    {
        this.notes = notes;
    }
    public void setCost(String cost)
    {
        this.cost = cost;
        
    }
    public void setQty(String qty)
    {
        this.qty = qty;
    }
    public String getId()
    {
        return this.id;
    }
    public String getNotes()
    {
        return this.notes;
    }
    public String getCost()
    {
        return this.cost;
    }
    public String getQty()
    {
        return this.qty;
    }
}
