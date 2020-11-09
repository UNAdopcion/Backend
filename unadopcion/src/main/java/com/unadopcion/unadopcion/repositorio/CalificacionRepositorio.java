package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Calificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepositorio extends CrudRepository<Calificacion, Integer> {

    List <Calificacion> findAllByUsuarioId(int usuarioId);

}
