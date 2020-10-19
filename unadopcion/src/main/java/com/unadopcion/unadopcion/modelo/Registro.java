package com.unadopcion.unadopcion.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "registro")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regisId;
    private Integer animId;
    private Integer usuarioId;
    private String regisFecha;

    public Registro() {
        animId = null;
        usuarioId = null;

    }

    public int getRegisId() {
        return regisId;
    }

    public void setRegisId(int regisId) {
        this.regisId = regisId;
    }

    public Integer getAnimId() {
        return animId;
    }

    public void setAnimId(Integer animalId) {
        this.animId = animalId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRegisFecha() {
        return regisFecha;
    }

    public void setRegisFecha(String regisFecha) {
        this.regisFecha = regisFecha;
    }
}