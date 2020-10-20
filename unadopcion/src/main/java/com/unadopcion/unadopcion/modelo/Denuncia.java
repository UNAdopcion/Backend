package com.unadopcion.unadopcion.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "denuncia")
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int denunId;

    private int usuarioId;
    private String denunFecha;
    private String denunTipo;
    private String denunDescrip;

    public Denuncia() {

    }

    public int getDenunId() {
        return this.denunId;
    }

    public void setDenunId(int denunId) {
        this.denunId = denunId;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getDenunFecha() {
        return this.denunFecha;
    }

    public void setDenunFecha(String denunFecha) {
        this.denunFecha = denunFecha;
    }

    public String getDenunTipo() {
        return this.denunTipo;
    }

    public void setDenunTipo(String denunTipo) {
        this.denunTipo = denunTipo;
    }

    public String getDenunDescrip() {
        return this.denunDescrip;
    }

    public void setDenunDescrip(String denunDescrip) {
        this.denunDescrip = denunDescrip;
    }

}