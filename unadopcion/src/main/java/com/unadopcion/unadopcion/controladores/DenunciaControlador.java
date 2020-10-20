package com.unadopcion.unadopcion.controladores;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.modelo.Denuncia;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.servicio.DenunciaServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DenunciaControlador {

    @Autowired
    private DenunciaServicio denunciaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/denunciarmaltrato", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    public String denunciarMaltrato(@RequestBody String json) throws JsonCampoNoExiste, JsonProcessingException {
        JsonLector jsonLector = new JsonLector(json);
        int usuarioId = Integer.parseInt(jsonLector.getJsonCampo("usuarioId"));
        Fecha fecha = new Fecha();
        String denunTipo = jsonLector.getJsonCampo("tipo");
        String denunDescrip = jsonLector.getJsonCampo("descripcion");
        boolean usuario = usuarioServicio.usuarioIdExiste(usuarioId);
        if (!usuario) {
            return "El usuario " + usuarioId + " no existe";
        } else {
            denunciaServicio.crearDenuncia(usuarioId, fecha.getFecha(), denunTipo, denunDescrip);
            System.out.println(usuarioId);
            return "Se ha registrado la denuncia.";
        }
    }

}