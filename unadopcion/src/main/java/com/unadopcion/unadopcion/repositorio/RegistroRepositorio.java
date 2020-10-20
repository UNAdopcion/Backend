package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Registro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepositorio extends CrudRepository <Registro, Integer>{


}