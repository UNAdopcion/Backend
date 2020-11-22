package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.pojo.VeterinariaPOJO;
import com.unadopcion.unadopcion.servicio.VeterinariaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class VeterinariaControlador {

    MiLogger miLogger = new MiLogger(VeterinariaControlador.class);

    @Autowired
    private VeterinariaServicio veterinariaServicio;



    @RequestMapping(value = "/registrar-veterinaria", method = RequestMethod.POST)
    public ResponseEntity<Void> registrarVeterinaria(@RequestBody VeterinariaPOJO veterinariaPOJO) {

        String nombre = veterinariaPOJO.getNombre();
        double latitud = veterinariaPOJO.getLatitud();
        double longitud = veterinariaPOJO.getLongitud();
        String direccion = veterinariaPOJO.getDireccion();
        int numero = veterinariaPOJO.getNumero();
        String sitioWeb = veterinariaPOJO.getSitioWeb();
        String descripcion = veterinariaPOJO.getDescripcion();

        Fecha fecha = new Fecha();

        boolean existe = veterinariaServicio.existePorLatitudYLongitud(latitud, longitud);


        if (existe) {
            miLogger.cuidado("La veterinaria ubicada en latitud:  " + latitud + " y longitud: "+ longitud + "ya esta registrada");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            veterinariaServicio.crearRegistroVeterinaria(nombre, latitud, longitud, direccion, numero, sitioWeb, descripcion, fecha.getFecha());
            miLogger.info("Se ha registrado la veterinaria " + nombre + ", latitud: "+ latitud + " y longitud: " + longitud);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
