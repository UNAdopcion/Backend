package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import com.unadopcion.unadopcion.servicio.RegistroServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.MultiValueMap;
import org.slf4j.Logger;

@RestController
public class RegistroControlador {

    private static final Logger logger = LoggerFactory.getLogger(RegistroControlador.class);

    @Autowired
    private RegistroServicio registroServicio;
    @Autowired
    private AnimalServicio animalServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    private Integer registroId;

    @RequestMapping("/registrarmascota")
    public String registrarMascota(@RequestBody MultiValueMap<String, String> valores) {

        logger.info("Valores:", valores);
        // Verifica si el usuario
        /*if (usuarioServicio.existeUsuario(usuarioid)) {

            Registro registro = registroServicio.crearRegistro(animalid, usuarioid, fecha);
            registroId = registro.getRegistroId();
            Animal animal = animalServicio.crearAnimal(animalnombre, animaltipo, animallugar, animaldescripcion,
                    animalsexo, animaledad, registroId);

            return "ID de la mascota: " + registro.getAnimalId() + "Asociada al usuario: " + registro.getUsuarioId();
        } else {
            return "El usuario con ID " + usuarioid + " no existe. ";
        }*/
        return "Respuesta OK";
    }
}