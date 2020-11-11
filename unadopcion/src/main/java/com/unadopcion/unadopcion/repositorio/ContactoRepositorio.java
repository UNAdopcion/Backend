package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends CrudRepository<Contacto, Integer> {

}
