package com.unadopcion.unadopcion.controladores;

import java.util.ArrayList;
import java.util.List;

import com.unadopcion.unadopcion.herramientas.Fecha;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Veterinaria;
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
            miLogger.cuidado("La veterinaria ubicada en latitud:  " + latitud + " y longitud: " + longitud
                    + "ya esta registrada");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            veterinariaServicio.crearRegistroVeterinaria(nombre, latitud, longitud, direccion, numero, sitioWeb,
                    descripcion, fecha.getFecha());
            miLogger.info(
                    "Se ha registrado la veterinaria " + nombre + ", latitud: " + latitud + " y longitud: " + longitud);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value = "/consultar-veterinaria", produces = "application/json")
    public List<Veterinaria> consultarVeterinaria() {
        List<Veterinaria> listaVeterinarias = new ArrayList<>();
        listaVeterinarias = veterinariaServicio.buscarVeterinarias();
        miLogger.info("El usuario " + " consulto todas las veterinarias");
        return listaVeterinarias;
    }

    // Servicio que permite consultar las veterinarias por nombre
    @PostMapping(value = "/consultar-veterinaria/nombre", produces = "application/json")
    public List<Veterinaria> consultarVeterinariaNombre(@RequestBody VeterinariaPOJO veterinariaPOJO) {

        String nombre = veterinariaPOJO.getNombre();
        List<Veterinaria> listaVeterinarias = new ArrayList<>();
        listaVeterinarias = veterinariaServicio.buscarVeterinariasNombre(nombre);
        miLogger.info("El usuario " + " consulto las veterinarias   que contienen el nombre : " + nombre);
        return listaVeterinarias;
    }

    // Servicio que permite consultar las veterinarias por calificacion
    @PostMapping(value = "/consultar-veterinaria/calificacion", produces = "application/json")
    public List<Veterinaria> consultarVeterinariaCalificacion(@RequestBody VeterinariaPOJO veterinariaPOJO) {
        List<Veterinaria> listaVeterinarias = new ArrayList<>();
        int calificacion = veterinariaPOJO.getCalificacion();
        listaVeterinarias = veterinariaServicio.buscarVeterinariasCalificacion(calificacion);
        miLogger.info("El usuario " + " consulto las veterinarias que tienen una calificacion de : " + calificacion);
        return listaVeterinarias;
    }

    // Servicio que permite consultar las veterinarias por varios parametros
    @PostMapping(value = "/consultar-veterinaria/varios", produces = "application/json")
    public List<Veterinaria> consultarVeterinariaVarios(@RequestBody VeterinariaPOJO veterinariaPOJO) {
        String nombre = veterinariaPOJO.getNombre();
        int calificacion = veterinariaPOJO.getCalificacion();
        List<Veterinaria> listaVeterinarias = new ArrayList<>();
        listaVeterinarias = veterinariaServicio.buscarVeterinariasVarios(nombre, calificacion);
        miLogger.info("El usuario " + " consulto las veterinarias que tienen una calificacion de : " + calificacion
                + " y cuyo nombre contiene: " + nombre);
        return listaVeterinarias;
    }
}
