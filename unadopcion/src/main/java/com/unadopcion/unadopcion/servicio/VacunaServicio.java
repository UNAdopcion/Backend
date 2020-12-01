package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Vacuna;
import com.unadopcion.unadopcion.repositorio.VacunaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VacunaServicio {

    @Autowired
    private VacunaRepositorio vacunaRepositorio;

    @Transactional
    public Vacuna crearVacuna( String vacunaNombre, String vacunaTipo, String vacunaClase) {

        Vacuna vacuna = new Vacuna();
        vacuna.setVacunaNombre(vacunaNombre);
        vacuna.setVacunaTipo(vacunaTipo);
        vacuna.setVacunaClase(vacunaClase);
        return vacunaRepositorio.save(vacuna);
    }

    public List<Vacuna> buscarVacunabyNombre(String vacunaNombre) {
        return vacunaRepositorio.findAllByVacunaNombre(vacunaNombre);
    }

    public List<Vacuna> buscarVacunas(){
        return vacunaRepositorio.findAll();
    }
}
