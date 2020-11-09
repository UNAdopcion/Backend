package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Calificacion;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.CalificacionPOJO;
import com.unadopcion.unadopcion.servicio.CalificacionServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CalificacionControlador {

    MiLogger miLogger = new MiLogger(CalificacionControlador.class);

    @Autowired
    private CalificacionServicio calificacionServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;


    @RequestMapping(value = "/realizar-calificacion", method = RequestMethod.POST)
    public ResponseEntity<Void> realizarCalificacion(@RequestBody CalificacionPOJO calificacionPOJO) {

        Usuario usuariocalificado = usuarioServicio.buscarUsuarioNombre(calificacionPOJO.getNombreUsuarioCalificado());
        Usuario usuariocalificador = usuarioServicio.buscarUsuarioNombre(calificacionPOJO.getNombreUsuarioCalificador());

        int usuarioId = usuariocalificado.getUsuarioId();
        Fecha comfecha = new Fecha();

        Integer puntaje= calificacionPOJO.getPuntaje();
        String comentario = calificacionPOJO.getComentario();


        boolean existe = usuarioServicio.usuarioIdExiste(usuarioId);

        ;
        if (!existe) {
            miLogger.cuidado("El usuario " + usuarioId + " no existe");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            calificacionServicio.crearCalificacion(usuariocalificado.getUsuarioId(),usuariocalificador.getUsuarioId(), puntaje, comfecha.getFecha(), comentario);
            miLogger.info("Se ha registrado la calificacion al usuario" + usuarioId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @GetMapping(value = "/consultar-calificacion/usuario/{nombre}", produces = "application/json")
    public List<Calificacion> consultaCalificacionPorUsuario(@PathVariable String nombre
    ) {

        Usuario usuarioCalificado = usuarioServicio.buscarUsuarioNombre(nombre);
        boolean existe = usuarioServicio.usuarioIdExiste(usuarioCalificado.getUsuarioId());
        if (!existe) {
            miLogger.cuidado("El usuario consultado " + usuarioCalificado.getUsuarioNombre() + " no existe. ");
        } else {
            miLogger.info("El usuario "
                    + " consulto la calificacion del usuario "
                    + usuarioCalificado.getUsuarioNombre());
        }
        return calificacionServicio.buscarCalificaionPorIdUsuario(usuarioCalificado.getUsuarioId());
    }

}