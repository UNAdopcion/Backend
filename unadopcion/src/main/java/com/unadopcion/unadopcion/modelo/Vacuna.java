package com.unadopcion.unadopcion.modelo;

import javax.persistence.*;

@Entity
@Table(name = "vacuna")

public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vacunaId;
    private String vacunaNombre;
    private String vacunaTipo;
    private String vacunaClase;

    public int getVacunaId() {
        return vacunaId;
    }

    public void setVacunaId(int vacunaId) {
        this.vacunaId = vacunaId;
    }

    public String getVacunaNombre() {
        return vacunaNombre;
    }

    public void setVacunaNombre(String vacunaNombre) {
        this.vacunaNombre = vacunaNombre;
    }

    public String getVacunaTipo() {
        return vacunaTipo;
    }

    public void setVacunaTipo(String vacunaTipo) {
        this.vacunaTipo = vacunaTipo;
    }

    public String getVacunaClase() {
        return vacunaClase;
    }

    public void setVacunaClase(String vacunaClase) {
        this.vacunaClase = vacunaClase;
    }

}
