package com.unadopcion.unadopcion.controladores;


import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.modelo.Registro;
import com.unadopcion.unadopcion.modelo.Solicitud;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.pojo.NuevaVacunaPOJO;
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

    private final String PENDIENTE = "Pendiente";
    private final String ACEPTADA = "Aceptada";
    private final String RECHAZADA = "Rechazada";

    @RequestMapping(value = "/Solicitud/Realizar/{animid}/{google_Id}")
    public ResponseEntity<Void> RealizarSolicitud(@PathVariable int animid, @PathVariable String google_Id) {

        Usuario user= usuarioServicio.findFirstByUsuarioGoogleId(google_Id);
        Animal animal=  animalServicio.findFirstByAnimId(animid);
        boolean existeSolicitud = solicitudServicio.existsByAnimidAndPersonaid(animal.getAnimId(),user.getUsuarioId());
        Registro registro = registroServicio.findFirstByAnimId(animid);
        if(existeSolicitud || registro.getUsuarioId() == user.getUsuarioId()){
            return new ResponseEntity<>(HttpStatus.OK);
        }

        Solicitud solicitud = new Solicitud();

        solicitud.setAnimid(animal.getAnimId());
        solicitud.setPersonaid(user.getUsuarioId());

        Fecha fecha = new Fecha();
        solicitud.setFecha(fecha.getFecha());

        solicitud.setEstado(PENDIENTE);

        solicitudServicio.save(solicitud);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/Solicitud/Consultar-Pendiente")
    public List<SolicitudConsultaPOJO> ConsultarPendiente(@RequestBody SolicitudConsultaPOJO solicitudConsultaPOJO){

        Usuario user= usuarioServicio.findFirstByUsuarioGoogleId(solicitudConsultaPOJO.getPersonaid());
        List<Registro> registros = registroServicio.findAllByUsuarioIdIsLike(user.getUsuarioId());

        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        for(int i = 0; i < registros.size(); i++){
            solicitudes.addAll(solicitudServicio.findAllByAnimid(registros.get(i).getAnimId()));
        }

        List<SolicitudConsultaPOJO> pojos = new ArrayList<SolicitudConsultaPOJO>();
        for(int i = 0; i < solicitudes.size(); i++){
            SolicitudConsultaPOJO pojo = new SolicitudConsultaPOJO();
            pojo.setId(solicitudes.get(i).getId());
            pojo.setAnimid(solicitudes.get(i).getAnimid());
            pojo.setFecha(solicitudes.get(i).getFecha());
            pojo.setEstado(solicitudes.get(i).getEstado());
            pojo.setPersonaid(solicitudConsultaPOJO.getPersonaid());
            pojo.setAnimNombre(animalServicio.findFirstByAnimId(solicitudes.get(i).getAnimid()).getAnimNombre());
            pojo.setPersonaNombre(usuarioServicio.findFirstByUsuarioId(solicitudes.get(i).getPersonaid()).getUsuarioNombreReal());

            pojos.add(pojo);
        }
        return pojos;

    }
}
