package com.unadopcion.unadopcion.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contacto")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contactoId;
    private String contactoNombre;
    private String contactoCorreo;
    private String contactoTipo;
    private String contactoCelular;
    private String contactoConsulta;

    public Contacto() {
    }

    public int getContactoId() { return contactoId; }

    public void setContactoId(int contactoId) { this.contactoId = contactoId; }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoCorreo() {
        return contactoCorreo;
    }

    public void setContactoCorreo(String contactoCorreo) {
        this.contactoCorreo = contactoCorreo;
    }

    public String getContactoTipo() {
        return contactoTipo;
    }

    public void setContactoTipo(String contactoTipo) {
        this.contactoTipo = contactoTipo;
    }

    public String getContactoCelular() {
        return contactoCelular;
    }

    public void setContactoCelular(String contactoCelular) {
        this.contactoCelular = contactoCelular;
    }

    public String getContactoConsulta() {
        return contactoConsulta;
    }

    public void setContactoConsulta(String contactoConsuta) {
        this.contactoConsulta = contactoConsulta;
    }


}
