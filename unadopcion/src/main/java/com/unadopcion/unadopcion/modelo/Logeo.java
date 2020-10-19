package com.unadopcion.unadopcion.modelo;


import javax.persistence.*;


@Entity
@Table( name = "logeo")
public class Logeo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int logeoId;
    private Integer usuarioId;
    private String logeoNombre;
    private String logeoContra;



    public Logeo() {
        usuarioId = null;
    }

    public int getLogeoId() {
        return logeoId;
    }

    public void setLogeoId(int logeoId) {
        this.logeoId = logeoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLogeoNombre() {
        return logeoNombre;
    }

    public void setLogeoNombre(String logeoNombre) {
        this.logeoNombre = logeoNombre;
    }

    public String getLogeoContra() {
        return logeoContra;
    }

    public void setLogeoContra(String logeoContrasena) {
        this.logeoContra = logeoContrasena;
    }
}
