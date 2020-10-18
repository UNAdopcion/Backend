package com.unadopcion.unadopcion.controladores;
import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import com.unadopcion.unadopcion.servicio.RegistroServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@CrossOrigin
@RestController
public class RegistroControlador {

    @Autowired
    private RegistroServicio registroServicio;
    @Autowired
    private AnimalServicio animalServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Transactional
    @RequestMapping(value="/registro",
            method = RequestMethod.POST,
            consumes = {"multipart/form-data"}, produces = "text/plain")
    public String registrarMascota(@RequestParam("imagen") MultipartFile archivo,
                                   @RequestParam("info") String json) throws IOException, JsonCampoNoExiste {

        JsonLector jsonLector = new JsonLector(json);
        String nombreusuario = jsonLector.getJsonCampo("nombreusuario");
        String animalnombre = jsonLector.getJsonCampo("animalnombre");
        String animaltipo = jsonLector.getJsonCampo("animaltipo");
        String animallugar = jsonLector.getJsonCampo("animallugar");
        String animaldescripcion = jsonLector.getJsonCampo("animaldescripcion");
        String animalsexo = jsonLector.getJsonCampo("animalsexo");
        int animaledad = Integer.parseInt(jsonLector.getJsonCampo("animaledad"));

        Fecha fecha = new Fecha();
        Usuario usuario = usuarioServicio.buscarUsuario(nombreusuario);
        //logger.info("Valores:", valores);
        // Verifica si el usuario existe
        if (usuarioServicio.usuarioExiste(nombreusuario)) {
            //crea una entidad registro primero
            Registro registro = registroServicio.crearRegistro(usuario.getUsuarioId(), fecha.getFecha());
            //crea una entidad animal luego con registro id
            Animal animal = animalServicio.crearAnimal(registro.getRegisId(), animalnombre,
                    animaltipo, animallugar, animaldescripcion, animalsexo, animaledad, archivo.getBytes());

            registro.setAnimId(animal.getAnimId());
            //guardar cambios posteriores a creacion
            registroServicio.guardar(registro);


            return "ID de la mascota: " + registro.getAnimId() + " Asociada al usuario: " + nombreusuario;
        } else {
            return "El usuario con nombre de usuario " + nombreusuario + " no existe. ";
        }

    }
}


// String imagen64 = "data:image;base64," +
//  + new String(Base64.getEncoder().encode(file.getBytes()));
//return imagen64;