package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepositorio extends CrudRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal  a where a.animTipo =?1")
    List<Animal> findAllByAnimTipo(String tipo);

    Animal findFirstByAnimId(int anim_id);

    @Query("SELECT a FROM Animal  a where a.animNombre =?1")
    List <Animal> findAllByAnimNombre(String nombre);

    @Query("SELECT a FROM Animal  a where a.animId =?1")
    List <Animal> findAllByAnimId(int animalId);
    Animal  getAnimalByAnimId(int animalId);
    boolean existsAnimalByAnimId(int animalId);
    List<Animal> findAll();
}
