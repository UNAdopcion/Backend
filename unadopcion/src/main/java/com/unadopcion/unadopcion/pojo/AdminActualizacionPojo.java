package com.unadopcion.unadopcion.pojo;

public class AdminActualizacionPojo {

    private String adminGoogleId;
    private String usuarioGoogleId;
    private String usuarioRol;
    private int usuarioPuntos;

    public String getAdminGoogleId() {
        return adminGoogleId;
    }

    public void setAdminGoogleId(String adminGoogleId) {
        this.adminGoogleId = adminGoogleId;
    }

    public String getUsuarioGoogleId() {
        return usuarioGoogleId;
    }

    public void setUsuarioGoogleId(String usuarioGoogleId) {
        this.usuarioGoogleId = usuarioGoogleId;
    }

    public String getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(String usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public int getUsuarioPuntos() {
        return usuarioPuntos;
    }

    public void setUsuarioPuntos(int usuarioPuntos) {
        this.usuarioPuntos = usuarioPuntos;
    }
}
