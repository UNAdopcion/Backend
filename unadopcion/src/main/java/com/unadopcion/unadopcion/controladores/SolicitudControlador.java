package com.unadopcion.unadopcion.controladores;


import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.modelo.Solicitud;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.SolicitudConsultaPOJO;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import com.unadopcion.unadopcion.servicio.RegistroServicio;
import com.unadopcion.unadopcion.servicio.SolicitudServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class SolicitudControlador {

    private final MiLogger miLogger = new MiLogger(RegistroControlador.class);

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private AnimalServicio animalServicio;

    @Autowired
    private SolicitudServicio solicitudServicio;

    @Autowired
    private RegistroServicio registroServicio;

    public final static String PENDIENTE = "Pendiente";
    public final static String ACEPTADA = "Aceptada";
    public final static String RECHAZADA = "Rechazada";

    @RequestMapping(value = "/Solicitud/Realizar/{animid}/{google_Id}")
    public ResponseEntity<Void> RealizarSolicitud(@PathVariable int animid, @PathVariable String google_Id) {

        Usuario user = usuarioServicio.findFirstByUsuarioGoogleId(google_Id);
        Animal animal = animalServicio.findFirstByAnimId(animid);
        boolean existeSolicitud = solicitudServicio.existsByAnimidAndPersonaid(animal.getAnimId(), user.getUsuarioId());
        Registro registro = registroServicio.findFirstByAnimId(animid);
        if (existeSolicitud || registro.getUsuarioId() == user.getUsuarioId()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        Solicitud solicitud = new Solicitud();

        solicitud.setAnimid(animal.getAnimId());
        solicitud.setPersonaid(user.getUsuarioId());

        Fecha fecha = new Fecha();
        solicitud.setFecha(fecha.getFecha());

        solicitud.setEstado(PENDIENTE);

        solicitudServicio.save(solicitud);
        miLogger.info("El usuario " + google_Id + " ha realizado la solicitud por " + animid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Solicitud/Cancelar/{id}")
    public ResponseEntity<Void> cancelarSolicitud(@PathVariable int id) {
        boolean solicitud = solicitudServicio.existsById(id);
        if (solicitud) {
            solicitudServicio.deleteById(id);
            miLogger.info("Se ha cancelado la solicitud " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/Solicitud/Rechazar/{id}")
    public ResponseEntity<Void> rechazarSolicitud(@PathVariable int id) {
        boolean existe = solicitudServicio.existsById(id);
        if (existe) {
            Solicitud solicitud = solicitudServicio.findFirstById(id);
            solicitud.setEstado(RECHAZADA);
            solicitudServicio.save(solicitud);
            miLogger.info("Se ha rechazado la solicitud " + id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/Solicitud/Aceptar/{solicitudId}/{googleId}")
    public ResponseEntity<Void> aceptarSolicitud(@PathVariable int solicitudId, @PathVariable String googleId) {
        boolean existe = solicitudServicio.existsById(solicitudId);
        if (existe) {
            Solicitud solicitud = solicitudServicio.findFirstById(solicitudId);
            if (solicitud.getEstado().equals(PENDIENTE)) {
                List<Solicitud> solicitudList = solicitudServicio.findAllByAnimid(solicitud.getAnimid());

                for (int i = 0; i < solicitudList.size(); i++) {
                    solicitudList.get(i).setEstado(RECHAZADA);
                    solicitudServicio.save(solicitudList.get(i));
                    miLogger.info("Se ha rechazado la solicitud " + solicitudList.get(i).getId());
                }

                Registro registro = registroServicio.findFirstByAnimId(solicitud.getAnimid());
                registro.setUsuarioId(solicitud.getPersonaid());

                Fecha fecha = new Fecha();
                registro.setRegisFecha(fecha.getFecha());

                solicitud.setEstado(ACEPTADA);
                solicitudServicio.save(solicitud);

                miLogger.info("Se ha aceptado la solicitud " + solicitud.getId());

                return new ResponseEntity<>(HttpStatus.ACCEPTED);

            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/Solicitud/Consultar-Pendiente")
    public List<SolicitudConsultaPOJO> ConsultarPendiente(@RequestBody SolicitudConsultaPOJO solicitudConsultaPOJO) {

        Usuario user = usuarioServicio.findFirstByUsuarioGoogleId(solicitudConsultaPOJO.getPersonaid());
        List<Registro> registros = registroServicio.findAllByUsuarioIdIsLike(user.getUsuarioId());

        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        for (int i = 0; i < registros.size(); i++) {
            solicitudes.addAll(solicitudServicio.findAllByAnimid(registros.get(i).getAnimId()));
        }

        solicitudes.addAll(solicitudServicio.findAllByPersonaidIsLike(user.getUsuarioId()));

        for (int i = 0; i < solicitudes.size() - 1; i++) {
            for (int j = i + 1; j < solicitudes.size(); j++) {
                if (solicitudes.get(i).equals(solicitudes.get(j))) {
                    solicitudes.remove(solicitudes.get(j));
                }
            }
        }
        List<SolicitudConsultaPOJO> pojos = new ArrayList<SolicitudConsultaPOJO>();
        for (int i = 0; i < solicitudes.size(); i++) {
            SolicitudConsultaPOJO pojo = new SolicitudConsultaPOJO();
            pojo.setId(solicitudes.get(i).getId());
            pojo.setAnimid(solicitudes.get(i).getAnimid());
            pojo.setFecha(solicitudes.get(i).getFecha());
            pojo.setEstado(solicitudes.get(i).getEstado());
            if (solicitudes.get(i).getPersonaid() == user.getUsuarioId()) {
                pojo.setPersonaid(user.getUsuarioGoogleId());
            } else {
                pojo.setPersonaid(null);
            }
            pojo.setAnimNombre(animalServicio.findFirstByAnimId(solicitudes.get(i).getAnimid()).getAnimNombre());
            pojo.setPersonaNombre(usuarioServicio.findFirstByUsuarioId(solicitudes.get(i).getPersonaid()).getUsuarioNombreReal());

            pojos.add(pojo);
        }

        return pojos;

    }
}