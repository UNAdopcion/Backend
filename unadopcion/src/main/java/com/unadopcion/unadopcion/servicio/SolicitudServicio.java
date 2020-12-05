package com.unadopcion.unadopcion.servicio;


import com.unadopcion.unadopcion.modelo.Solicitud;
import com.unadopcion.unadopcion.repositorio.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SolicitudServicio {

    @Autowired
    private SolicitudRepositorio solicitudRepositorio;

    public Solicitud save(Solicitud solicitud) {
        return solicitudRepositorio.save(solicitud);
    }

    public boolean existsByAnimidAndPersonaid(int Anim_id, int Persona_id) {
        return solicitudRepositorio.existsByAnimidAndPersonaid(Anim_id, Persona_id);
    }

    public boolean existsById(int id) {
        return solicitudRepositorio.existsById(id);
    }

    @Transactional(readOnly = true)
    public List<Solicitud> findAllByAnimid(int animid) {
        return solicitudRepositorio.findAllByAnimid(animid);
    }

    @Transactional(readOnly = true)
    public List<Solicitud> findAllByPersonaidIsLike(int personaId) {
        return solicitudRepositorio.findAllByPersonaidIsLike(personaId);
    }

    public void deleteById(int id) {
        solicitudRepositorio.deleteById(id);
    }

    public Solicitud findFirstById(int id) {
        return solicitudRepositorio.findFirstById(id);
    }
}