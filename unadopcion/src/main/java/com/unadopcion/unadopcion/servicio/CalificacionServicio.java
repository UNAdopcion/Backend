package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Calificacion;
import com.unadopcion.unadopcion.repositorio.CalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CalificacionServicio {

    @Autowired
    private CalificacionRepositorio calificacionRepositorio;

    @Transactional
    public Calificacion crearCalificacion(int idUsuarioCalificado, int idUsuarioCalificador, int puntaje, String fecha, String comentario){

        Calificacion calificacion = new Calificacion();
        calificacion.setUsuarioCalificado(idUsuarioCalificado);
        calificacion.setUsuarioCalificador(idUsuarioCalificador);
        calificacion.setPuntaje(puntaje);
        calificacion.setComFecha(fecha);
        calificacion.setComentario(comentario);

        return calificacionRepositorio.save(calificacion);

    }

    public List<Calificacion> buscarCalificaionPorIdUsuario(int idUsuario){
        return calificacionRepositorio.findAllByUsuarioId(idUsuario);
    }

    public Calificacion guardar(Calificacion calificacion){
        return calificacionRepositorio.save(calificacion);
    }
}

