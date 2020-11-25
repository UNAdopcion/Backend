package com.unadopcion.unadopcion.pojo;

public class VeterinariaPOJO {
    private String nombre;
    private double latitud;
    private double longitud;
    private String direccion;
    private int numero;
    private String sitioWeb;
    private String descripcion;
    private int calificacion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumero() {
        return numero;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }
}
