package com.unadopcion.unadopcion.repositorio;
import com.unadopcion.unadopcion.modelo.Adopcion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopcionRepositorio extends CrudRepository<Adopcion, Integer> {


    //boolean existsAdopcionAprobada(int animalId);
}
