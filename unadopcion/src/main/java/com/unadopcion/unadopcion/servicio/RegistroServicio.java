package com.unadopcion.unadopcion.servicio;

import javax.transaction.Transactional;

import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.repositorio.RegistroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroServicio {

    @Autowired
    private RegistroRepositorio registroRepositorio;

    @Transactional
    public Registro crearRegistro(int usuarioId, String fecha) {

        Registro registro = new Registro();
        registro.setUsuarioId(usuarioId);
        registro.setRegisFecha(fecha);
        return registroRepositorio.save(registro);

    }

    public Registro guardar(Registro registro){
        return registroRepositorio.save(registro);
    }

    public List<Registro> findAllByUsuarioIdIsLike(int personaid){
        return registroRepositorio.findAllByUsuarioIdIsLike(personaid);
    }

    public Registro findFirstByAnimId(int animid){
        return registroRepositorio.findFirstByAnimId(animid);
    }
}