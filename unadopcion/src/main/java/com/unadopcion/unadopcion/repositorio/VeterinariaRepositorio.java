package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Veterinaria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinariaRepositorio extends CrudRepository<Veterinaria, Integer> {

    List <Veterinaria> findAllByNombre(String nombre);
    Veterinaria findVeterinariaByVeterinariaId (int idVeterinaria);
    boolean existsVeterinariaByLatitudAndLongitud(double latitud, double longitud);
    boolean existsVeterinariaByVeterinariaId(int idVeterinaria);

}
