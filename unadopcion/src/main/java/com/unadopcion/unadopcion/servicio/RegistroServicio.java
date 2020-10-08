package com.unadopcion.unadopcion.servicio;

import javax.transaction.Transactional;

import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.repositorio.RegistroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroServicio {

    @Autowired
    private RegistroRepositorio registroRepositorio;

    @Transactional
    public Registro crearRegistro(int animalId, int usuarioId, String fecha) {

        Registro registro = new Registro();
        registro.setAnimalId(animalId);
        registro.setUsuarioId(usuarioId);
        registro.setRegistroFecha(fecha);
        return registroRepositorio.save(registro);

    }

}