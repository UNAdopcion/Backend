package com.unadopcion.unadopcion.repositorio;


import com.unadopcion.unadopcion.modelo.Solicitud;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SolicitudRepositorio extends CrudRepository<Solicitud, Integer> {

    boolean existsByAnimidAndPersonaid(int Anim_id, int Persona_id);

    boolean existsById(int id);

    @Query("SELECT s FROM Solicitud  s where s.animid =?1")
    List<Solicitud> findAllByAnimid(int animid);

    @Query("SELECT s FROM Solicitud  s where s.personaid = ?1")
    List<Solicitud> findAllByPersonaidIsLike(int personaId);


}
