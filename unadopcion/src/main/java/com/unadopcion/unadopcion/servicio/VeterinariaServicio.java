package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Veterinaria;
import com.unadopcion.unadopcion.repositorio.VeterinariaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VeterinariaServicio {

    @Autowired
    private VeterinariaRepositorio veterinariaRepositorio;

    @Transactional
    public Veterinaria crearRegistroVeterinaria(String nombre, double latitud, double longitud, String direccion,
            int numero, String sitioWeb, String descripcion, String fecha) {
        Veterinaria veterinaria = new Veterinaria();

        veterinaria.setNombre(nombre);
        veterinaria.setLatitud(latitud);
        veterinaria.setLongitud(longitud);
        veterinaria.setDireccion(direccion);
        veterinaria.setNumero(numero);
        veterinaria.setSitioWeb(sitioWeb);
        veterinaria.setDescripcion(descripcion);
        veterinaria.setFecha(fecha);

        return veterinariaRepositorio.save(veterinaria);
    }

    public List<Veterinaria> buscarVeterinariaPorNombre(String nombre) {
        return veterinariaRepositorio.findAllByNombre(nombre);
    }

    public Veterinaria buscarVeterinariaPorId(int idVeterinaria) {
        return veterinariaRepositorio.findVeterinariaByVeterinariaId(idVeterinaria);
    }

    public boolean existePorLatitudYLongitud(double latitud, double longitud) {
        return veterinariaRepositorio.existsVeterinariaByLatitudAndLongitud(latitud, longitud);
    }

    public boolean existeVeterinariaPorId(int idVeterinaria) {
        return veterinariaRepositorio.existsVeterinariaByVeterinariaId(idVeterinaria);
    }

    public Veterinaria guardar(Veterinaria veterinaria) {
        return veterinariaRepositorio.save(veterinaria);
    }

    public List<Veterinaria> buscarVeterinarias() {
        return veterinariaRepositorio.findAll();
    }

    public List<Veterinaria> buscarVeterinariasNombre(String nombre) {
        return veterinariaRepositorio.findAllByNombreIsLike(nombre);
    }

    public List<Veterinaria> buscarVeterinariasCalificacion(int calificacion) {
        return veterinariaRepositorio.findAllByCalificacion(calificacion);
    }

    public List<Veterinaria> buscarVeterinariasVarios(String nombre, int calificacion) {
        return veterinariaRepositorio.findAllByNombreCalificacion(nombre, calificacion);
    }
}
