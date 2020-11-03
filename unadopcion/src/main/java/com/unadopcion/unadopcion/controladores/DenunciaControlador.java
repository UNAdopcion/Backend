package com.unadopcion.unadopcion.controladores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.JsonLector;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.modelo.Denuncia;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.ConsultarDenunciaPOJO;
import com.unadopcion.unadopcion.pojo.DenunciaPOJO;
import com.unadopcion.unadopcion.servicio.DenunciaServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DenunciaControlador {

    MiLogger miLogger = new MiLogger(DenunciaControlador.class);

    @Autowired
    private DenunciaServicio denunciaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/consultar-maltrato/{id}", produces = "application/json")
    public List<Denuncia> consultaMaltratoId(@PathVariable int id) {
        return denunciaServicio.buscarDenunciaByAnimalId(id);
    }

    @RequestMapping(value = "/denunciar-maltrato", method = RequestMethod.POST)
    public ResponseEntity<Void> denunciarMaltrato(@RequestBody DenunciaPOJO denunciaPOJO) {

        Usuario usuario = usuarioServicio.buscarUsuario(denunciaPOJO.getNombreUsuario());

        int usuarioId = 0;
        usuarioId = usuario.getUsuarioId();
        int animalId = 0;
        animalId = denunciaPOJO.getAnimalId();
        Fecha fecha = new Fecha();
        String denunTipo = denunciaPOJO.getDenunTipo();
        String denunDescrip = denunciaPOJO.getDenunDescrip();
        String detalles = denunciaPOJO.getDetalles();

        boolean existe = usuarioServicio.usuarioIdExiste(usuarioId);

        ;
        if (!existe) {
            miLogger.cuidado("El usuario " + usuarioId + " no existe");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            denunciaServicio.crearDenuncia(usuarioId, animalId, fecha.getFecha(), denunTipo, denunDescrip, detalles);
            miLogger.info("Se ha registrado la denuncia del usuario" + usuarioId);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @GetMapping(value = "/consultar-maltrato/usuario/{nombre}", produces = "application/json")
    public List<Denuncia> consultaMaltratoPorNombreUsuario(@PathVariable String nombre
            //,@RequestBody ConsultarDenunciaPOJO consultarDenunciaPOJO
            ) {
        //Usuario usuario = usuarioServicio.buscarUsuario(consultarDenunciaPOJO.getNombreUsuario());
        Usuario usuario_consultado = usuarioServicio.buscarUsuario(nombre);
        boolean existe = usuarioServicio.usuarioIdExiste(usuario_consultado.getUsuarioId());
        if (!existe) {
            miLogger.cuidado("El usuario consultado " + usuario_consultado.getUsuarioNombre() + " no existe. ");
        } else {
            miLogger.info("El usuario " //+ usuario.getUsuarioNombre() 
            + " consulto los casos de maltrato del usuario "
                    + usuario_consultado.getUsuarioNombre());
        }
        return denunciaServicio.buscarDenunciaByUser(usuario_consultado.getUsuarioId());
    }

}