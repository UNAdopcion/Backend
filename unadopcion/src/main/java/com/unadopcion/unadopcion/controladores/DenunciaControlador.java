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

    @RequestMapping(value = "/consultar-maltrato/{id}", produces = "application/json")
    public List<Denuncia> consultaMaltratoId(@PathVariable int id) {
        return denunciaServicio.buscarDenunciaByAnimalId(id);
    }

    @RequestMapping(value = "/denunciar-maltrato", method = RequestMethod.POST)
    public ResponseEntity<Void> denunciarMaltrato(@RequestBody DenunciaPOJO denunciaPOJO) {
        Usuario usuario = usuarioServicio.buscarUsuarioNombre(denunciaPOJO.getNombreUsuario());
        int usuarioId = 0;
        usuarioId = usuario.getUsuarioId();
        int animalId = 8;
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
            miLogger.info("Se ha registrado la denuncia del usuario " + usuario.getUsuarioGoogleId());
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    // Servicio que busca las denuncia de maltrato animal asociadas a un usuario y
    // las filtra por id del animal y fecha
    @RequestMapping(value = "/consultar-maltrato", method = RequestMethod.POST, produces = "application/json")
    public List<Denuncia> consultaMaltratoPorNombreUsuario(@RequestBody ConsultarDenunciaPOJO consultarPOJO) {
        Usuario usuario_consultado = usuarioServicio.buscarUsuarioNombre(consultarPOJO.getNombreUsuario());
        boolean existe = usuarioServicio.usuarioIdExiste(usuario_consultado.getUsuarioId());
        List<Denuncia> listaDenuncias = new ArrayList<Denuncia>();
        List<Denuncia> listaDenunciasFiltrada = new ArrayList<Denuncia>();
        listaDenuncias = denunciaServicio.buscarDenunciaByUser(usuario_consultado.getUsuarioId());
        if (!consultarPOJO.getIdMascota().equals("")) {
            for (Denuncia denuncia : listaDenuncias) {
                if (denuncia.getAnimalId() == Integer.parseInt(consultarPOJO.getIdMascota())) {
                    listaDenunciasFiltrada.add(denuncia);
                }
            }
            listaDenuncias = listaDenunciasFiltrada;
        }
        if (!consultarPOJO.getFecha().equals("")) {
            listaDenunciasFiltrada = new ArrayList<Denuncia>();
            for (Denuncia denunciaF : listaDenuncias) {
                if (consultarPOJO.getFecha().equals(denunciaF.getDenunFecha().substring(0, 10))) {
                    listaDenunciasFiltrada.add(denunciaF);
                }
            }
            listaDenuncias = listaDenunciasFiltrada;
        }
        if (!existe) {
            miLogger.cuidado("El usuario consultado " + usuario_consultado.getUsuarioNombre() + " no existe. ");
        } else {
            miLogger.info("El usuario " + " consulto los casos de maltrato del usuario "
                    + usuario_consultado.getUsuarioNombre());
        }
        return listaDenuncias;
    }

}