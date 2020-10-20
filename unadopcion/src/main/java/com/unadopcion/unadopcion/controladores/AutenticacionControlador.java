package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.servicio.LogeoServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AutenticacionControlador {

    @Autowired
    LogeoServicio logeoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/autenticar", method = RequestMethod.GET, consumes = "application/json", produces = "text/plain")
    public String autenticarUsuario(@RequestBody String json) throws JsonCampoNoExiste, JsonProcessingException {
        JsonLector jsonLector = new JsonLector(json);
        String nombre = jsonLector.getJsonCampo("nombre");
        String contrasena = jsonLector.getJsonCampo("contrasena");
        boolean existe = usuarioServicio.usuarioExiste(nombre);
        if (!existe) {
            return "El usuario con nombre " + nombre + " no existe";
        } else {
            if (logeoServicio.autenticar(nombre, contrasena)) {
                return "Acceso permitido.";
            } else {
                return "Acceso denegado.";
            }
        }
    }

}