package com.unadopcion.unadopcion.controladores;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.pojo.EditarMascotaPOJO;
import com.unadopcion.unadopcion.pojo.EstadoEsterilizacionPOJO;
import com.unadopcion.unadopcion.pojo.MicrochipPOJO;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class EditarMascotaControlador {

    private MiLogger miLogger = new MiLogger(EditarMascotaControlador.class);

    @Autowired
    private AnimalServicio animalServicio;

    @RequestMapping(value="/mostrar-mascota/{animalId}", produces = "application/json")
    public String mostrarMascota(@PathVariable int animalId) throws JsonProcessingException {
        List<Animal> resultado = animalServicio.buscarAnimalPorAnimalId(animalId);
        ObjectMapper mapper = new ObjectMapper();
        String respuestaJson = mapper.writeValueAsString(resultado);
        miLogger.info("Busqueda animal por:" + animalId);
        return respuestaJson;
    }


    @RequestMapping(value = "/editar-mascota")
    public ResponseEntity<Void> editarMascota(@RequestBody EditarMascotaPOJO editarMascotaPOJO){
        boolean animalExiste = animalServicio.animalExiste(editarMascotaPOJO.getAnimalId());
        Animal animal = null;
        // si existe editar este usuario
        if(animalExiste){
            animal = animalServicio.buscarAnimalPorID(editarMascotaPOJO.getAnimalId());
            animal.setAnimId(editarMascotaPOJO.getAnimalId());
            animal.setAnimNombre(editarMascotaPOJO.getAnimalnombre());
            animal.setAnimTipo(editarMascotaPOJO.getAnimaltipo());
            animal.setAnimLugar(editarMascotaPOJO.getAnimallugar());
            animal.setAnimDescrip(editarMascotaPOJO.getAnimaldescripcion());
            animal.setAnimSexo(editarMascotaPOJO.getAnimalsexo());
            animal.setAnimEdad(editarMascotaPOJO.getAnimaledad());
            animal.setAnimMicrochipId(editarMascotaPOJO.getAnimalmicrochipid());
            animal.setAnimEsterilizacion(editarMascotaPOJO.getAnimalesterilizacion());;
            animalServicio.guardar(animal);
            miLogger.info("La mascota con nombre " + animal.getAnimNombre() + "edita sus datos");
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            //algo raro pasa porque todos los id deberian estar en la BD si es editar
            miLogger.cuidado("La mascota identidicada con ID:  " + editarMascotaPOJO.getAnimalId()  + "NO existe en BD");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/editar-microchip")
    public ResponseEntity<Void> editarMicrochipID(@RequestBody MicrochipPOJO microchipPOJO){
        boolean animalExiste = animalServicio.animalExiste(microchipPOJO.getAnimalId());
        Animal animal = null;
        // si existe editar el microchip ID
        if(animalExiste){
            animal = animalServicio.buscarAnimalPorID(microchipPOJO.getAnimalId());
            animal.setAnimId(microchipPOJO.getAnimalId());
            animal.setAnimMicrochipId(microchipPOJO.getAnimalmicrochipid());
            animalServicio.guardar(animal);
            miLogger.info("La mascota con nombre " + animal.getAnimNombre() + "edita microchipID");
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            miLogger.cuidado("La mascota identidicada con ID: " + microchipPOJO.getAnimalId() + "NO existe en BD");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/editar-esterilizacion")
    public ResponseEntity<Void> editarEstadoEsterilizacion(@RequestBody EstadoEsterilizacionPOJO estadoEsterilizacionPOJO){
        boolean animalExiste = animalServicio.animalExiste(estadoEsterilizacionPOJO.getAnimalId());
        Animal animal = null;
        // si existe editar el microchip ID
        if(animalExiste){
            animal = animalServicio.buscarAnimalPorID(estadoEsterilizacionPOJO.getAnimalId());
            animal.setAnimId(estadoEsterilizacionPOJO.getAnimalId());
            animal.setAnimEsterilizacion(estadoEsterilizacionPOJO.getAnimalesterilizacion());
            animalServicio.guardar(animal);
            miLogger.info("La mascota con nombre " + animal.getAnimNombre() + "edita estado esterilización");
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            miLogger.cuidado("La mascota identidicada con ID: " + estadoEsterilizacionPOJO.getAnimalId() + "NO existe en BD");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
