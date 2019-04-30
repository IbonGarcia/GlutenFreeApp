package com.example.ibon.glutenfreeapp;

import java.io.Serializable;

public class Lugar implements Serializable{

    private int id;
    private String nombre;
    private String telefono;
    private int tipo;
    private double latitud;
    private double longitud;
    private String calle;
    private String foto;
    private String descripcion;

    public Lugar(int id, String nom, String telef, int tipo, double lat, double longi,String calle, String foto, String desc){

        this.id=id;
        this.nombre=nom;
        this.telefono=telef;
        this.tipo=tipo;
        this.latitud=lat;
        this.longitud=longi;
        this.calle = calle;
        this.foto=foto;
        this.descripcion=desc;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getLatitud() {
        return latitud;
    }


    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
}
