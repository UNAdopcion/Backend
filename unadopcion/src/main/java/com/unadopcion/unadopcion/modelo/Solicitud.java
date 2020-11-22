package com.unadopcion.unadopcion.modelo;

import javax.persistence.*;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int animid;
    private String fecha;
    private String estado;
    private int personaid;


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

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }




}
