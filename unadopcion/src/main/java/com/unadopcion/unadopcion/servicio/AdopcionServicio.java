package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Adopcion;
import com.unadopcion.unadopcion.repositorio.AdopcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AdopcionServicio {
    @Autowired
    private AdopcionRepositorio adopcionRepositorio;


    @Transactional
    public Adopcion crearAdopcion(int animalId, int usuarioId, String adopcionFecha){

        Adopcion adopcion = new Adopcion();
        adopcion.setAnimId(animalId);
        adopcion.setUsuarioId(usuarioId);
        adopcion.setAdopFecha(adopcionFecha);
        return adopcionRepositorio.save(adopcion);

    }
    public Adopcion guardar(Adopcion adopcion){
        return adopcionRepositorio.save(adopcion);
    }

    public boolean animalHaSidoAdoptado(int animalId){

        return adopcionRepositorio.existsByAnimId(animalId);
    }

    public Optional buscarAdopcionById(int id){
        return adopcionRepositorio.findById(id);
    }

}
