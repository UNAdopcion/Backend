package com.unadopcion.unadopcion.controladores;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ConsultarMascotaControlador {

    private MiLogger miLogger = new MiLogger(ConsultarMascotaControlador.class);
    @Autowired
    private AnimalServicio animalServicio;


    @RequestMapping(value = "/consultar-mascota/{nombre}", produces = "application/json")
    public String buscarAnimalPorNombre(@PathVariable String nombre) throws JsonProcessingException  {
        List<Animal> resultados = animalServicio.buscarAnimalPorNombre(nombre);
        ObjectMapper mapper = new ObjectMapper();
        String respuestaJson = mapper.writeValueAsString(resultados);
        miLogger.info("Busqueda animal por:" + nombre);
        return respuestaJson;
    }
}
