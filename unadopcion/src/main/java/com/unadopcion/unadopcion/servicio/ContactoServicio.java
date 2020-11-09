package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Contacto;
import com.unadopcion.unadopcion.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ContactoServicio {
    @Autowired
    private ContactoRepositorio contactoRepositorio;

    @Transactional
    public Contacto crearRegistroContacto(String contactoNombre, String contactoCorreo, String contactoTipo, String contactoCelular, String contactoConsulta) {

        Contacto contacto = new Contacto();
        contacto.setContactoNombre(contactoNombre);
        contacto.setContactoCorreo(contactoCorreo);
        contacto.setContactoTipo(contactoTipo);
        contacto.setContactoCelular(contactoCelular);
        contacto.setContactoConsulta(contactoConsulta);
        return contactoRepositorio.save(contacto);

    }

}
