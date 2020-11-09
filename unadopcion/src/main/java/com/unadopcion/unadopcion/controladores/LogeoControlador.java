package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.EditarUsuarioPOJO;
import com.unadopcion.unadopcion.servicio.LogeoServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class LogeoControlador {

    MiLogger miLogger = new MiLogger(LogeoControlador.class);
    @Autowired
    private LogeoServicio logeoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/editar-usuario")
    public ResponseEntity<Void> editarUsuario(@RequestBody EditarUsuarioPOJO editarUsuarioPOJO){
        boolean usuarioExiste = usuarioServicio.usuarioExistePorGoogleId(editarUsuarioPOJO.getGoogleId());
        Usuario usuario = null;
        // si existe editar este usuario
        if(usuarioExiste){
            usuario = usuarioServicio.buscarUsuarioPorGoogleId(editarUsuarioPOJO.getGoogleId());
            usuario.setUsuarioGoogleId(editarUsuarioPOJO.getGoogleId());
            usuario.setUsuarioTelefono(editarUsuarioPOJO.getTelefono());
            usuario.setUsuarioLugar(editarUsuarioPOJO.getLugar());
            usuario.setUsuarioInfo(editarUsuarioPOJO.getInfo());
            usuarioServicio.guardar(usuario);
            miLogger.info("Usuario con nombre " + usuario.getUsuarioNombreReal() + "edita perfil");
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            //algo raro pasa porque todos los id deberian estar en la BD si es editar
            miLogger.cuidado("usuario envia googleId que no existe en BD: " + editarUsuarioPOJO.getGoogleId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/mostrar-perfil/{googleid}", produces = "application/json")
    public Usuario buscarUsuarioPorId(@PathVariable  String googleid) {

        if(usuarioServicio.usuarioExistePorGoogleId(googleid)) {
            return usuarioServicio.buscarUsuarioPorGoogleId(googleid);
        }else{
            miLogger.cuidado("No existe usuario con el googleId " + googleid);
            return null;
        }
    }

    @RequestMapping(value = "mostrar-usuarios/{nombre}", produces = "application/json")
    public List<Usuario> mostrarUsuarios(@PathVariable String nombre){
        return usuarioServicio.buscarUsuarios(nombre);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
