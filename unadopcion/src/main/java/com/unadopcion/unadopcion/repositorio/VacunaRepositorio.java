package com.unadopcion.unadopcion.repositorio;

import java.util.List;
import com.unadopcion.unadopcion.modelo.Vacuna;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepositorio extends CrudRepository <Vacuna,Integer> {

    List<Vacuna> findAllByVacunaNombre(String vacunaNombre);
    List<Vacuna> findAll();

}
