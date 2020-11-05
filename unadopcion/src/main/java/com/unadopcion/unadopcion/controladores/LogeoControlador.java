package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Logeo;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.NuevoUsuarioPOJO;
import com.unadopcion.unadopcion.pojo.UsuarioLogeoPOJO;
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
    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/crear-usuario")
    public ResponseEntity<Void> crearNuevoUsuario(@RequestBody NuevoUsuarioPOJO nuevoUsuarioPOJO)  {
        boolean nombreExiste = logeoServicio.existsByNombre(nuevoUsuarioPOJO.getNombre());
        // crea logeo primero, verifica que no exista usuario nombre o usuario con mismo
        // correo
        if (!nombreExiste) {
            Logeo logeo = new Logeo();
            Usuario user = new Usuario();

            // primero crear logeo
            logeo.setLogeoNombre(nuevoUsuarioPOJO.getNombre());
            logeo.setLogeoContra(passwordEncoder.encode(nuevoUsuarioPOJO.getContrasena()));
            logeo = logeoServicio.crearLogeo(logeo);

            // crear usuario con el id del logeo
            user.setLogeoId(logeo.getLogeoId());
            user.setUsuarioNombre(nuevoUsuarioPOJO.getNombre());
            user.setUsuarioNombreReal(nuevoUsuarioPOJO.getNombreReal());
            user.setUsuarioEmail(nuevoUsuarioPOJO.getCorreo());
            user.setUsuarioTelefono(nuevoUsuarioPOJO.getTelefono());
            user.setUsuarioRol(nuevoUsuarioPOJO.getRol());
            user.setUsuarioLugar(nuevoUsuarioPOJO.getLugar());
            user.setUsuarioInfo(nuevoUsuarioPOJO.getInfo());
            user = usuarioServicio.crearUsuario(user);

            logeo.setUsuarioId(user.getUsuarioId());
            logeoServicio.crearLogeo(logeo);

            miLogger.info("Se registro un nuevo usuario con el mombre " + user.getUsuarioNombre() + " y rol "
                    + user.getUsuarioRol());
            //nuevo usuario creado
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
                miLogger.cuidado("Usuario tratando de registrarse con el nombre " + nuevoUsuarioPOJO.getNombre() + " pero ya existe");
                //el usuario con ese nombre ya existe
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }


    @RequestMapping(value = "/editar-usuario")
    public ResponseEntity<Void> editarUsuario(@RequestBody NuevoUsuarioPOJO editarUsuarioPOJO){

        boolean nombreExisteLog = logeoServicio.existsByNombre(editarUsuarioPOJO.getNombre());
        boolean nombreExisteUser = usuarioServicio.usuarioExiste(editarUsuarioPOJO.getNombre());

        if(nombreExisteLog && nombreExisteUser){
            Usuario user = usuarioServicio.buscarUsuario(editarUsuarioPOJO.getNombre());
            Logeo logeo = logeoServicio.buscarNombre(editarUsuarioPOJO.getNombre());

            user.setUsuarioNombreReal(editarUsuarioPOJO.getNombreReal());
            user.setUsuarioEmail(editarUsuarioPOJO.getCorreo());
            user.setUsuarioTelefono(editarUsuarioPOJO.getTelefono());
            logeo.setLogeoContra(passwordEncoder.encode(editarUsuarioPOJO.getContrasena()));
            user.setUsuarioRol(editarUsuarioPOJO.getRol());
            user.setUsuarioLugar(editarUsuarioPOJO.getLugar());
            user.setUsuarioInfo(editarUsuarioPOJO.getInfo());

            logeoServicio.editar(logeo);
            usuarioServicio.editar(user);

            miLogger.info("Se registro edición de usuario con el mombre " + user.getUsuarioNombre() + " y rol "
                    + user.getUsuarioRol());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/hacer-logeo")
    public ResponseEntity<Void> hacerLogeo(@RequestBody UsuarioLogeoPOJO usuarioLogeoPOJO)  {

        boolean existe = usuarioServicio.usuarioExiste(usuarioLogeoPOJO.getNombre());
        // si el usuario existe intentar logeo
        if (!existe) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// el usuario no fue encontrado
        } else {
            //intentar logeo, si no, returnar no autorizado
            Logeo logeo = logeoServicio.buscarNombre(usuarioLogeoPOJO.getNombre());
            if (passwordEncoder.matches(usuarioLogeoPOJO.getContrasena(), logeo.getLogeoContra())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
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
