package com.unadopcion.unadopcion.modelo;

import javax.persistence.*;

@Entity
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int solici_id;
    int anim_id;
    String solici_fecha;
    String solici_estado;
    int persona_id;

    public int getSolici_id() {
        return solici_id;
    }

    public void setSolici_id(int solici_id) {
        this.solici_id = solici_id;
    }

    public int getAnim_id() {
        return anim_id;
    }

    public void setAnim_id(int anim_id) {
        this.anim_id = anim_id;
    }

    public String getSolici_fecha() {
        return solici_fecha;
    }

    public void setSolici_fecha(String solici_fecha) {
        this.solici_fecha = solici_fecha;
    }

    public String getSolici_estado() {
        return solici_estado;
    }

    public void setSolici_estado(String solici_estado) {
        this.solici_estado = solici_estado;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
}
