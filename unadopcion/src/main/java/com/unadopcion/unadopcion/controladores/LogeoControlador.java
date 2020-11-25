package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.EditarUsuarioPOJO;
import com.unadopcion.unadopcion.pojo.AdminActualizacionPojo;
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

    private static String ROL_ADMIN = "admin";
    private static String ROL_ADOPTADOR = "adoptador";
    private static String ROL_CUIDADOR = "cuidador";
    private static String ROL_VISITANTE = "visitante";


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
    public Usuario buscarUsuarioPorId(@PathVariable String googleid) {

        if (usuarioServicio.usuarioExistePorGoogleId(googleid)) {
            return usuarioServicio.buscarUsuarioPorGoogleId(googleid);
        } else {
            miLogger.cuidado("No existe usuario con el googleId " + googleid);
            return null;
        }
    }

    @RequestMapping(value = "mostrar-usuarios/{nombre}", produces = "application/json")
    public List<Usuario> mostrarUsuarios(@PathVariable String nombre) {
        return usuarioServicio.buscarUsuarios(nombre);
    }

    @RequestMapping(value = "/actualizar")
    public ResponseEntity<Void> adminActualizar(@RequestBody AdminActualizacionPojo adminActualizacionPojo) {

        Usuario usuario = usuarioServicio.buscarUsuarioPorGoogleId(adminActualizacionPojo.getUsuarioGoogleId());
        Usuario admin = usuarioServicio.buscarUsuarioPorGoogleId(adminActualizacionPojo.getAdminGoogleId());

        //mirar si la peticion viene de un admin usuando el google id
        //TODO: quitar la vulnerabilidad de que la persona logeada puede
        //TODO: no ser un admin y enviar el googleId de cualquier admin y realizar cambios
        //TODO: POSIBLE SOLUCION, CREAR UN PASSWORD PARA ADMIN Y ENVIARLO EN LA PETICION(UNA VEZ POR SESION)
        //admin no edita admin solo a otros usuarios con roles inferiores
        if(admin.getUsuarioRol().equals(ROL_ADMIN) && !usuario.getUsuarioRol().equals(ROL_ADMIN)){
            usuario.setUsuarioRol(adminActualizacionPojo.getUsuarioRol());
            usuario.setUsuarioPuntos(adminActualizacionPojo.getUsuarioPuntos());
            usuarioServicio.guardar(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
