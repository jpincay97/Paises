package com.example.paises.Model;

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

}
