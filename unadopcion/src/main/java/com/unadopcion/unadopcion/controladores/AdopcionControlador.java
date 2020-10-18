package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.modelo.Adopcion;
import com.unadopcion.unadopcion.servicio.AdopcionServicio;
import com.unadopcion.unadopcion.servicio.AnimalServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdopcionControlador {

    @Autowired
    private AdopcionServicio adopcionServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private AnimalServicio animalServicio;


    @RequestMapping("/crearadopcion")
    public String crearAdopcion(@RequestParam int animalid,
                                @RequestParam int usuarioid,
                                @RequestParam String adopcionfecha){

        if(false){//TODO:Animal No debe haber sido adoptado

            //crear adopcion
            Adopcion adopcion = adopcionServicio.crearAdopcion(animalid, usuarioid, adopcionfecha);
            return "Solicitud creada con id " + adopcion.getAdopId();
        }else{

            return "El animal con id " + animalid + "ya fue adoptado";
        }

    }


}
