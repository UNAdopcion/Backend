package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.modelo.Logeo;

import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.servicio.LogeoServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
public class LogeoControlador {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private LogeoServicio logeoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    private Integer logeoId;

    @RequestMapping(value="/crearusuario",
            method = RequestMethod.POST,
            consumes = "application/json", produces = "text/plain")
    public String crearNuevoUsuario(@RequestBody String json) throws JsonProcessingException {
         JsonNode jsonNode = objectMapper.readTree(json);
         String nombre = jsonNode.get("nombre").asText();
         String correo = jsonNode.get("correo").asText();
         String telefono = jsonNode.get("telefono").asText();
         String contrasena = jsonNode.get("nombre").asText();
         //crea registro logeo primero
         if(!logeoServicio.existsByNombre(nombre))
         {
             Logeo logeo = logeoServicio.crearLogeo(nombre, contrasena);
             logeoId = logeo.getLogeoId();
             //crear usuario con el id del logeo
             Usuario usuario = usuarioServicio.crearUsuario(logeoId,  nombre, correo, telefono);
             return "ID nuevo usuario: " + usuario.getUsuarioId();
         }else{

             return "El nombre de usuario " + nombre + " ya existe";
         }



    }
    //esto es para poner en usuarioControlador
    @GetMapping("/buscausuario/{id}")
    public Optional<Usuario> buscarUsuario(@PathVariable Integer id){

        return usuarioServicio.buscarUsuario(id);
    }

    @GetMapping("/listar")
    public Iterable<Logeo> getLogeos(){
       return null;
    }

    @RequestMapping(value = "/probar",
            method = RequestMethod.POST,
            consumes = "application/json", produces = "text/plain")
    public String probar(@RequestBody String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.get("nombre").asText();
    }
}
