package com.unadopcion.unadopcion.pojo;

import java.security.PrivateKey;

public class ContactoPOJO {
    private String contactoNombre;
    private String contatoCorreo;
    private String contactoTipo;
    private String contactoCelular;
    private String ContactoConsulta;

    public String getContactoNombre() { return contactoNombre; }

    public void setContactoNombre(String contactoNombre) { this.contactoNombre = contactoNombre; }

    public String getContatoCorreo() { return contatoCorreo; }

    public void setContatoCorreo(String contatoCorreo) { this.contatoCorreo = contatoCorreo; }

    public String getContactoTipo() { return contactoTipo; }

    public void setContactoTipo(String contactoTipo) { this.contactoTipo = contactoTipo; }

    public String getContactoCelular() { return contactoCelular; }

    public void setContactoCelular(String contactoCelular) {
        this.contactoCelular = contactoCelular;
    }

    public String getContactoConsulta() {
        return ContactoConsulta;
    }

    public void setContactoConsulta(String contactoConsulta) {
        ContactoConsulta = contactoConsulta;
    }


}
