package com.unadopcion.unadopcion.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int registroId;
    private int animalId;
    private int usuarioId;
    private String registroFecha;

    public Registro() {
    }

    public int getRegistroId() {
        return registroId;
    }

    public void setRegistroId(int registroId) {
        this.registroId = registroId;

    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;

    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int idAnimal) {
        this.animalId = idAnimal;
    }

    public void setRegistroFecha(String fecha) {
        this.registroFecha = fecha;
    }

    public String getRegistroFecha() {
        return registroFecha;
    }

}