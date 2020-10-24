package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
public class BusquedaAnimalControlador {


    private MiLogger miLogger = new MiLogger(BusquedaAnimalControlador.class);
    @Autowired
    private AnimalServicio animalServicio;

    @RequestMapping(value="/buscar-mascota/{tipo}", produces = "application/json")
    public String buscarAnimalPorTipo(@PathVariable String tipo) throws JsonProcessingException {
            List<Animal> resultados = animalServicio.buscarAnimalPorTipo(tipo);
            ObjectMapper mapper = new ObjectMapper();
            String respuestaJson = mapper.writeValueAsString(resultados);
            miLogger.info("Busqueda animal por:" + tipo);
           return respuestaJson;

    }


}
