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
        boolean correoExiste = usuarioServicio.existeEmail(nuevoUsuarioPOJO.getCorreo());
        // crea logeo primero, verifica que no exista usuario nombre o usuario con mismo
        // correo
        if (!nombreExiste && !correoExiste) {
            // primero crear logeo
            Logeo logeo = logeoServicio.crearLogeo(nuevoUsuarioPOJO.getNombre(), passwordEncoder.encode(nuevoUsuarioPOJO.getContrasena()
            ));
            // crear usuario con el id del logeo
            Usuario usuario = usuarioServicio.crearUsuario(logeo.getLogeoId(), nuevoUsuarioPOJO.getNombre(), nuevoUsuarioPOJO.getNombreReal(), nuevoUsuarioPOJO.getCorreo(), nuevoUsuarioPOJO.getTelefono());
            logeo.setUsuarioId(usuario.getUsuarioId());
            // guardar cambio a logeo
            logeoServicio.guardar(logeo);

            miLogger.info("Se registro un nuevo usuario con el mombre " + usuario.getUsuarioNombre() + " y rol "
                    + usuario.getUsuarioRol());
            //nuevo usuario creado
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {

            if (nombreExiste) {
                miLogger.cuidado("Usuario tratando de registrarse con el nombre " + nuevoUsuarioPOJO.getNombre() + " pero ya existe");
                //el usuario con ese nombre ya existe
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                miLogger.cuidado("El correo  " + nuevoUsuarioPOJO.getCorreo() + " esta asociado con otra cuenta");
                //el correo esta ya en usuo
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

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

    @RequestMapping(value = "/mostrar-perfil")
    public Usuario buscarUsuarioPorNombre(@RequestBody String nombre) {

        if(usuarioServicio.usuarioExiste(nombre)) {
            return usuarioServicio.buscarUsuario(nombre);
        }else{
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
