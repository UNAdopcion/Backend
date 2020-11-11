package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.pojo.ContactoPOJO;
import com.unadopcion.unadopcion.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class ContactoControlador {
    private MiLogger miLogger = new MiLogger(ContactoControlador.class);

    @Autowired
    private ContactoServicio contactoServicio;

    @PostMapping(value = "/contacto")
    public ResponseEntity<Void>  crearRegistroContacto(@RequestBody ContactoPOJO contactoPOJO) {
        String contactoNombre = contactoPOJO.getContactoNombre();
        String contactoCorreo = contactoPOJO.getContactoCorreo();
        String contactoTipo= contactoPOJO.getContactoTipo();
        String contactoCelular= contactoPOJO.getContactoCelular();
        String contactoConsulta= contactoPOJO.getContactoConsulta();

        contactoServicio.crearRegistroContacto(contactoNombre, contactoCorreo, contactoTipo, contactoCelular, contactoConsulta);
        miLogger.info("Se han registrado los datos de contacto");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
