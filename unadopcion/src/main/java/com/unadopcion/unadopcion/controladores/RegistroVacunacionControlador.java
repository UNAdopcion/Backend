package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.pojo.NuevoRegistroVacunavionPOJO;
import com.unadopcion.unadopcion.servicio.AnimalVacunaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RegistroVacunacionControlador {
    private MiLogger miLogger = new MiLogger(RegistroVacunacionControlador.class);

    @Autowired
    private AnimalVacunaServicio animalVacunaServicio;

    @PostMapping(value = "/registro-vacunacion", produces = "application/json")
    public ResponseEntity<Void> crearRegistroVacunacion (@RequestBody NuevoRegistroVacunavionPOJO nuevoRegistroVacunavionPOJO) {
        String animVacFecha = nuevoRegistroVacunavionPOJO.getAnimVacFecha();
        int animId = nuevoRegistroVacunavionPOJO.getAnimId();
        int vacunaId = nuevoRegistroVacunavionPOJO.getVacunaId();
        int veterinariaId = nuevoRegistroVacunavionPOJO.getVeterinariaId();

        animalVacunaServicio .crearRegistroVacunacion(animVacFecha, animId, vacunaId, veterinariaId);
        miLogger.info("La vacuna ha sido registrada exitosamente");
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
