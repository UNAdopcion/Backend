package com.unadopcion.unadopcion.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "calificacion")
public class Calificacion {

    @Id
    private int usuarioCalificado;
    @Id
    private int usuarioCalificador;


    private Integer puntaje;
    private String comFecha;
    private String comentario;



    public Calificacion() {
    }

    public int getUsuarioCalificado() {
        return usuarioCalificado;
    }

    public int getUsuarioCalificador() {
        return usuarioCalificador;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public String getComFecha() {
        return comFecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setUsuarioCalificado(int usuarioCalificado) {
        this.usuarioCalificado = usuarioCalificado;
    }

    public void setUsuarioCalificador(int usuarioCalificador) {
        this.usuarioCalificador = usuarioCalificador;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public void setComFecha(String comFecha) {
        this.comFecha = comFecha;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
