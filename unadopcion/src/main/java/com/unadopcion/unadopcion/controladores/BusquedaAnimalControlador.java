package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.servicio.AnimalServicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class BusquedaAnimalControlador {

    Logger logger = LoggerFactory.getLogger(BusquedaAnimalControlador.class);

    @Autowired
    private AnimalServicio animalServicio;

    @RequestMapping(value="/buscarmascota")
    public String buscarAnimalPorTipo(@RequestBody String json) throws JsonCampoNoExiste, JsonProcessingException {
            JsonLector jsonLector = new JsonLector(json);
            String tipo = jsonLector.getJsonCampo("tipo");
            List<Animal> resultados = animalServicio.buscarAnimalPorTipo(tipo);
            ObjectMapper mapper = new ObjectMapper();
            String respuestaJson = mapper.writeValueAsString(resultados);
           return respuestaJson;

    }


}
