package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.AnimalVacuna;
import com.unadopcion.unadopcion.repositorio.AnimalVacunaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AnimalVacunaServicio {

    @Autowired
    private AnimalVacunaRepositorio animalVacunaRepositorio;

    @Transactional
    public AnimalVacuna crearRegistroVacunacion(String animVacFecha, int animId, int vacunaId, int veterinariaId){
        AnimalVacuna animalVacuna = new AnimalVacuna();
        animalVacuna.setAnimVacFecha(animVacFecha);
        animalVacuna.setAnimId(animId);
        animalVacuna.setVacunaId(vacunaId);
        animalVacuna.setVeterinariaId(veterinariaId);
        return animalVacunaRepositorio.save(animalVacuna);
    }
}
