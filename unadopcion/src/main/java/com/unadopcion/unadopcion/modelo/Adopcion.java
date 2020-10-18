package com.unadopcion.unadopcion.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adopId;
    private int animId;
    private int usuarioId;
    private String adopFecha;
    private String adopEstado;

    public String getAdopEstado() {
        return adopEstado;
    }

    public void setAdopEstado(String adopcionEstado) {
        this.adopEstado = adopcionEstado;
    }

    public Adopcion() {
    }

    public int getAdopId() {
        return adopId;
    }

    public void setAdopId(int adopcionId) {
        this.adopId = adopcionId;
    }

    public int getAnimId() {
        return animId;
    }

    public void setAnimId(int animalId) {
        this.animId = animalId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAdopFecha() {
        return adopFecha;
    }

    public void setAdopFecha(String adopcionFecha) {
        this.adopFecha = adopcionFecha;
    }
}