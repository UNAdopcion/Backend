package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Logeo;
import org.springframework.data.repository.CrudRepository;


public interface LogeoRepositorio extends CrudRepository<Logeo, Integer> {

    boolean existsByLogeoNombre(String nombre);
    Logeo findByLogeoNombre(String nombre);
}
