package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Denuncia;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.ConsultarDenunciaPOJO;
import com.unadopcion.unadopcion.pojo.DenunciaPOJO;
import com.unadopcion.unadopcion.servicio.DenunciaServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class DenunciaControlador {

    MiLogger miLogger = new MiLogger(DenunciaControlador.class);

    @Autowired
    private DenunciaServicio denunciaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping(value = "/consultar-maltrato/{id}", produces = "application/json")
    public List<Denuncia> consultaMaltratoId(@PathVariable int id) {
        return denunciaServicio.buscarDenunciaByAnimalId(id);
    }

    @PostMapping(value = "/denunciar-maltrato")
    public ResponseEntity<Void> denunciarMaltrato(@RequestBody DenunciaPOJO denunciaPOJO) {
        Usuario usuario = usuarioServicio.buscarUsuarioNombre(denunciaPOJO.getNombreUsuario());
        int usuarioId = 0;
        usuarioId = usuario.getUsuarioId();
        int animalId = 3;
        Fecha fecha = new Fecha();
        String denunTipo = denunciaPOJO.getDenunTipo();
        String denunDescrip = denunciaPOJO.getDenunDescrip();
        String detalles = denunciaPOJO.getDetalles();
        boolean existe = usuarioServicio.usuarioIdExiste(usuarioId);
        if (!existe) {
            miLogger.cuidado("El usuario " + usuarioId + " no existe");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            denunciaServicio.crearDenuncia(usuarioId, animalId, fecha.getFecha(), denunTipo, denunDescrip, detalles);
            miLogger.info("Se ha registrado la denuncia del usuario " + usuario.getUsuarioGoogleId());
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    // Servicio que busca las denuncia de maltrato animal asociadas a un usuario y
    // las filtra por id del animal y fecha
    @PostMapping(value = "/consultar-maltrato", produces = "application/json")
    public List<Denuncia> consulMaltrato(@RequestBody ConsultarDenunciaPOJO consultarPOJO) {
        Usuario usuarioConsultado = usuarioServicio.buscarUsuarioNombre(consultarPOJO.getNombreUsuario());
        List<Denuncia> listaDenuncias = new ArrayList<>();
        if (usuarioConsultado == null) {
            miLogger.cuidado("El usuario consultado " + consultarPOJO.getNombreUsuario() + " no existe. ");
        } else {
            listaDenuncias = denunciaServicio.buscarDenunciaByUser(usuarioConsultado.getUsuarioId());
            if (!consultarPOJO.getIdMascota().equals("")) {
                listaDenuncias = denunciaServicio.buscarMaltratoIdMascota(listaDenuncias,
                        Integer.parseInt(consultarPOJO.getIdMascota()));
            }
            if (!consultarPOJO.getFecha().equals("")) {

                listaDenuncias = denunciaServicio.buscarMaltratoFecha(listaDenuncias, consultarPOJO.getFecha());
            }
            miLogger.info("El usuario " + " consulto los casos de maltrato del usuario "
                    + usuarioConsultado.getUsuarioNombre());
        }
        return listaDenuncias;
    }

}