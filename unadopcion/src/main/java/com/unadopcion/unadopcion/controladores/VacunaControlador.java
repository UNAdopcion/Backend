package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Vacuna;
import com.unadopcion.unadopcion.pojo.NuevaVacunaPOJO;
import com.unadopcion.unadopcion.servicio.VacunaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class VacunaControlador {
    private MiLogger miLogger = new MiLogger(ContactoControlador.class);

    @Autowired
    private VacunaServicio vacunaServicio;

    @PostMapping(value = "/ingresar-vacuna", produces = "application/json")
    public ResponseEntity<Void> crearVacuna(@RequestBody NuevaVacunaPOJO nuevaVacunaPOJO) {
        String vacunaNombre = nuevaVacunaPOJO.getVacunaNombre();
        String vacunaTipo = nuevaVacunaPOJO.getVacunaTipo();
        String vacunaClase = nuevaVacunaPOJO.getVacunaClase();
        vacunaServicio.crearVacuna(vacunaNombre, vacunaTipo, vacunaClase);
        miLogger.info("La vacuna ha sido registrada exitosamente");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/consultar-vacuna", produces = "application/json")
    public List<Vacuna> consultarVacuna() {
        List<Vacuna> listaVacunas = new ArrayList<>();
        listaVacunas = vacunaServicio.buscarVacunas();
        miLogger.info("El usuario " + " consulto todas las veterinarias");
        return listaVacunas;
    }

    @RequestMapping(value = "/consultar-vacuna/{vacunaNombre}", produces = "application/json")
    public String buscarVacunabyNombre(@PathVariable String vacunaNombre)  throws JsonProcessingException {
        List<Vacuna> resultados = vacunaServicio.buscarVacunabyNombre(vacunaNombre);
        ObjectMapper mapper = new ObjectMapper();
        String respuestaJson = mapper.writeValueAsString(resultados);
        miLogger.info("Busqueda animal por:" + vacunaNombre);
        return respuestaJson;
    }

}


