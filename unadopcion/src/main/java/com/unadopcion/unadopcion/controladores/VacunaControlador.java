package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.pojo.NuevaVacunaPOJO;
import com.unadopcion.unadopcion.servicio.VacunaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class VacunaControlador {
    private MiLogger miLogger = new MiLogger(ContactoControlador.class);

    @Autowired
    private VacunaServicio vacunaServicio;

    @PostMapping(value = "/vacunas", produces = "application/json")
    public ResponseEntity<Void> crearVacuna(@RequestBody NuevaVacunaPOJO nuevaVacunaPOJO) {
        String vacunaNombre = nuevaVacunaPOJO.getVacunaNombre();
        String vacunaTipo = nuevaVacunaPOJO.getVacunaTipo();
        String vacunaClase = nuevaVacunaPOJO.getVacunaClase();

        vacunaServicio.crearVacuna(vacunaNombre, vacunaTipo, vacunaClase);
        miLogger.info("La vacuna ha sido registrada exitosamente");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


