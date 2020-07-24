package com.example.paises.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pais {

    private String name;
    private String imagen;

    public Pais(String name, String imagen) {
        this.name = name;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pais(JSONObject a) throws JSONException {
        name =  a.getString("name").toString() ;
        imagen = "http://www.geognos.com/api/en/countries/flag/"+a.getString("alpha2Code").toString()+".png";
    }

    public static ArrayList<Pais> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Pais> paises = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<250; i++) {
            paises.add(new Pais(datos.getJSONObject(i)));
        }
        return paises;
    }

}
