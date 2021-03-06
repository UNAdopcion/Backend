package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Veterinaria;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinariaRepositorio extends CrudRepository<Veterinaria, Integer> {

    List<Veterinaria> findAllByNombre(String nombre);

    Veterinaria findVeterinariaByVeterinariaId(int idVeterinaria);

    boolean existsVeterinariaByLatitudAndLongitud(double latitud, double longitud);

    boolean existsVeterinariaByVeterinariaId(int idVeterinaria);

    List<Veterinaria> findAll();

    @Query("SELECT u from Veterinaria u WHERE u.nombre like %:nombre%")
    List<Veterinaria> findAllByNombreIsLike(String nombre);

    @Query("SELECT u from Veterinaria u WHERE u.calificacion like :calif")
    List<Veterinaria> findAllByCalificacion(int calif);

    @Query("SELECT u from Veterinaria u WHERE u.calificacion like :calif AND  u.nombre like %:nombre%")
    List<Veterinaria> findAllByNombreCalificacion(String nombre, int calif);

}
