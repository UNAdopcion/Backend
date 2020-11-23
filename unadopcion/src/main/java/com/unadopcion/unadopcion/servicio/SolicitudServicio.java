package com.unadopcion.unadopcion.servicio;


import com.unadopcion.unadopcion.modelo.Solicitud;
import com.unadopcion.unadopcion.repositorio.SolicitudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServicio {

    @Autowired
    private SolicitudRepositorio solicitudRepositorio;

    public void save(Solicitud solicitud) {
        solicitudRepositorio.save(solicitud);
    }

    public boolean existsByAnimidAndPersonaid(int Anim_id, int Persona_id){
        return solicitudRepositorio.existsByAnimidAndPersonaid(Anim_id, Persona_id);
    }

    public List<Solicitud> findAllByAnimid(int animid){
        return solicitudRepositorio.findAllByAnimid(animid);
    }
}