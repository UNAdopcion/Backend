package com.unadopcion.unadopcion.controladores;


import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.modelo.Solicitud;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import com.unadopcion.unadopcion.servicio.SolicitudServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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

    private final String PENDIENTE = "Pendiente";
    private final String ACEPTADA = "Aceptada";
    private final String RECHAZADA = "Rechazada";

    @RequestMapping(value = "/Solicitud/Realizar/{anim_id}/{google_Id}")
    public ResponseEntity<Void> consultaMaltratoId(@PathVariable int anim_id, @PathVariable String google_Id) {

        Usuario user= usuarioServicio.findFirstByUsuarioGoogleId(google_Id);
        Animal animal=  animalServicio.findFirstByAnimId(anim_id);

        boolean existeSolicitud = solicitudServicio.existsByAnimidAndPersonaid(animal.getAnimId(),user.getUsuarioId());

        if(existeSolicitud){
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

}
