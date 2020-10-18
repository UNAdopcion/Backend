package com.unadopcion.unadopcion.repositorio;
import com.unadopcion.unadopcion.modelo.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepositorio extends CrudRepository<Animal, Integer> {

    List<Animal> findAllByAnimTipo(String tipo);
}
