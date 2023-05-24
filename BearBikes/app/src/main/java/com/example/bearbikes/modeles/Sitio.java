package com.example.bearbikes.modeles;

import java.io.Serializable;

public class Sitio implements Serializable {

    private int ID;
    private String Nombre;
    private String Descripcion;
    private String Direccion;

    public Sitio(){}

    public Sitio(int ID, String nombre, String descripcion, String direccion) {
        this.ID = ID;
        Nombre = nombre;
        Descripcion = descripcion;
        Direccion = direccion;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    @Override
    public String toString() {
        return "ID: " + ID + " | Nombre: " + Nombre + " | Descripción: " + Descripcion + " | Dirección: " + Direccion;
    }
}






