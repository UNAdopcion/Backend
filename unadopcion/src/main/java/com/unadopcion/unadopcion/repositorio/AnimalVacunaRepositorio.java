package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.AnimalVacuna;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnimalVacunaRepositorio extends CrudRepository <AnimalVacuna, Integer> {
    //@Query("select animal.*,animal_vacuna.*  from animal,animal_vacuna where animal.anim_id = animal_vacuna.anim_id =?1")

}
