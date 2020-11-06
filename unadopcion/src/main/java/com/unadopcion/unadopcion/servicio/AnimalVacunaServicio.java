package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.AnimalVacuna;
import com.unadopcion.unadopcion.repositorio.AnimalVacunaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class AnimalVacunaServicio {
    @Autowired
    private AnimalVacunaRepositorio animalVacunaRepositorio;

    @Transactional
    public AnimalVacuna crearRegistroVacuna(int  animVacId, int animId, int vacunaId, int vetId){
        AnimalVacuna animalVacuna = new AnimalVacuna();
        animalVacuna.setAnimVacId(animVacId);
        animalVacuna.setAnimId(animId);
        animalVacuna.setVacunaId(vacunaId);
        animalVacuna.setVetId(vetId);
        return animalVacunaRepositorio.save(animalVacuna);
    }
}
