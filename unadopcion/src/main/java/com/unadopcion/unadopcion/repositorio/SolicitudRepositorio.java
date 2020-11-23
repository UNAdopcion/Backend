package com.unadopcion.unadopcion.repositorio;


import com.unadopcion.unadopcion.modelo.Solicitud;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepositorio extends CrudRepository<Solicitud, Integer> {

    boolean existsByAnimidAndPersonaid(int Anim_id, int Persona_id);

    List<Solicitud> findAllByAnimid(int animid);
}
