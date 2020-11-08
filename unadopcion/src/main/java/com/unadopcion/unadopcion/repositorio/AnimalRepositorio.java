package com.unadopcion.unadopcion.repositorio;
import com.unadopcion.unadopcion.modelo.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnimalRepositorio extends CrudRepository<Animal, Integer> {

    List<Animal> findAllByAnimTipo(String tipo);

}
