package com.unadopcion.unadopcion.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Adopcion {
    @Id
    private int adopcionId;
    private int animalId;
    private int usuarioId;
    private String adopcionFecha;
    private String adopcionEstado;

    public String getAdopcionEstado() {
        return adopcionEstado;
    }

    public void setAdopcionEstado(String adopcionEstado) {
        this.adopcionEstado = adopcionEstado;
    }

    public Adopcion() {
    }

    public int getAdopcionId() {
        return adopcionId;
    }

    public void setAdopcionId(int adopcionId) {
        this.adopcionId = adopcionId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAdopcionFecha() {
        return adopcionFecha;
    }

    public void setAdopcionFecha(String adopcionFecha) {
        this.adopcionFecha = adopcionFecha;
    }
}