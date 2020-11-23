package com.unadopcion.unadopcion.pojo;

public class SolicitudConsultaPOJO {

    private int id;
    private int animid;
    private String fecha;
    private String estado;
    private String personaid;

    private String personaNombre;
    private String animNombre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimid() {
        return animid;
    }

    public void setAnimid(int animid) {
        this.animid = animid;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPersonaid() {
        return personaid;
    }

    public void setPersonaid(String personaid) {
        this.personaid = personaid;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getAnimNombre() {
        return animNombre;
    }

    public void setAnimNombre(String animNombre) {
        this.animNombre = animNombre;
    }

}
