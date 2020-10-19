package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unadopcion.unadopcion.modelo.Logeo;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.servicio.LogeoServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
public class LogeoControlador {

    Logger logger = LoggerFactory.getLogger(LogeoControlador.class);

    @Autowired
    private LogeoServicio logeoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/crearusuario", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    public String crearNuevoUsuario(@RequestBody String json) throws JsonCampoNoExiste, JsonProcessingException {
        JsonLector jsonLector = new JsonLector(json);
        String nombre = jsonLector.getJsonCampo("nombre");
        String correo = jsonLector.getJsonCampo("correo");
        String telefono = jsonLector.getJsonCampo("telefono");
        String contrasena = jsonLector.getJsonCampo("contrasena");
        boolean nombreExiste = logeoServicio.existsByNombre(nombre);
        boolean correoExiste = usuarioServicio.existeEmail(correo);
        // crea logeo primero, verifica que no exista usuario nombre o usuario con mismo
        // correo
        if (!nombreExiste && !correoExiste) {
            // primero crear logeo
            Logeo logeo = logeoServicio.crearLogeo(nombre, contrasena);
            // crear usuario con el id del logeo
            Usuario usuario = usuarioServicio.crearUsuario(logeo.getLogeoId(), nombre, correo, telefono);
            logeo.setUsuarioId(usuario.getUsuarioId());
            // guardar cambio a logeo
            logeoServicio.guardar(logeo);
            logger.info("Se registro un nuevo usuario con el mombre " + usuario.getUsuarioNombre() + " y rol "
                    + usuario.getUsuarioRol() );
            return "ID nuevo usuario: " + usuario.getUsuarioId();
        } else {

            if (nombreExiste) {
                logger.error("Usuario tratando de registrarse con el nombre " + nombre + " pero ya existe");
                return "El nombre de usuario " + nombre + " ya existe";
            } else {
                logger.error("El correo  " + correo + " esta asociado con otra cuenta");
                return "El correo " + correo + " ya existe";
            }

        }

    }

    // esto es para poner en usuarioControlador
    @GetMapping("/buscausuario/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable Integer id) {

        return usuarioServicio.buscarUsuario(id);
    }

    @GetMapping("/listar")
    public Iterable<Logeo> getLogeos() {
        return null;
    }

}
