package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.JsonAPOJO;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.NuevaMascotaPOJO;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import com.unadopcion.unadopcion.servicio.RegistroServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@CrossOrigin
@RestController
public class RegistroControlador {

    private MiLogger miLogger = new MiLogger(RegistroControlador.class);
    @Autowired
    private RegistroServicio registroServicio;
    @Autowired
    private AnimalServicio animalServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Transactional
    @PostMapping(value = "/registro", consumes = { "multipart/form-data" })
    public ResponseEntity<Void> registrarMascota(@RequestPart("imagen") MultipartFile archivo,
            @RequestParam("info") String json) throws IOException {

        // Fecha ahora
        Fecha fecha = new Fecha();
        // convertir json a POJO
        JsonAPOJO jsonAPOJO = new JsonAPOJO();
        NuevaMascotaPOJO nuevaMascotaPOJO = (NuevaMascotaPOJO) jsonAPOJO.getPOJO(json, NuevaMascotaPOJO.class);

        Usuario usuario = usuarioServicio.buscarUsuarioPorGoogleId(nuevaMascotaPOJO.getUsuariogoogleid());
        // Verifica si el usuario existe
        if (usuarioServicio.usuarioExistePorGoogleId(nuevaMascotaPOJO.getUsuariogoogleid())) {
            // crea una entidad registro primero
            Registro registro = registroServicio.crearRegistro(usuario.getUsuarioId(), fecha.getFecha());
            // crea una entidad animal luego con registro id
            Animal animal = animalServicio.crearAnimal(registro.getRegisId(), nuevaMascotaPOJO.getAnimalnombre(),
                    nuevaMascotaPOJO.getAnimaltipo(), nuevaMascotaPOJO.getAnimallugar(),
                    nuevaMascotaPOJO.getAnimaldescripcion(), nuevaMascotaPOJO.getAnimalsexo(),
                    nuevaMascotaPOJO.getAnimaledad(), archivo.getBytes());

            registro.setAnimId(animal.getAnimId());
            // guardar cambios posteriores a creacion de registro
            registroServicio.guardar(registro);

            miLogger.info("Se registro mascota con id:" + registro.getAnimId());
            // Una mascota ha sido creada
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            miLogger.info(
                    "Se intenta registrar mascota con usuario no existente:" + nuevaMascotaPOJO.getNombreusuario());
            // El usuario no existe para registrar mascota
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
