package com.unadopcion.unadopcion.modelo;

import javax.persistence.*;

@Entity
@Table(name = "veterinaria")
public class Veterinaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int veterinariaId;
    private String nombre;
    private double latitud;
    private double longitud;
    private String direccion;
    private int numero;
    private String sitioWeb;
    private String descripcion;
    private String fecha;
    private int calificacion = 0;
    private int calificadores = 0;

    public void setVeterinariaId(int veterinariaId) {
        this.veterinariaId = veterinariaId;
    }

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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getVeterinariaId() {
        return veterinariaId;
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

    public String getFecha() {
        return fecha;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificadores(int calificadores) {
        this.calificadores = calificadores;
    }

    public int getCalificadores(int calificadores) {
        return calificadores;
    }
}
