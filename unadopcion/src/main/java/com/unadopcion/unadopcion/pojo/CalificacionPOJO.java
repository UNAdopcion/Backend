package com.unadopcion.unadopcion.pojo;

public class CalificacionPOJO {

    private String nombreUsuarioCalificado;

    //sugerencia para revisar, mejor dejar int este proximo campo
    private String nombreUsuarioCalificador;
    private Integer puntaje;
    private String comentario;

    public String getNombreUsuarioCalificado() {
        return nombreUsuarioCalificado;
    }

    public String getNombreUsuarioCalificador() {
        return nombreUsuarioCalificador;
    }

    public Integer getPuntaje() {
        return puntaje;
    }


    public String getComentario() {
        return comentario;
    }

    public void setNombreUsuarioCalificado(String nombreUsuarioCalificado) {
        this.nombreUsuarioCalificado = nombreUsuarioCalificado;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }


    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNombreUsuarioCalificador(String nombreUsuarioCalificador) {
        this.nombreUsuarioCalificador = nombreUsuarioCalificador;
    }
}
