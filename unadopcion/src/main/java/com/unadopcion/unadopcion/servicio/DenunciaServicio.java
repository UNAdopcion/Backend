package com.unadopcion.unadopcion.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.unadopcion.unadopcion.modelo.Denuncia;
import com.unadopcion.unadopcion.repositorio.DenunciaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciaServicio {
    @Autowired
    private DenunciaRepositorio denunciaRepositorio;

    @Transactional
    public Denuncia crearDenuncia(int usuarioId, int animalId, String denunFecha, String denunTipo, String denunDescrip,
            String detalles) {

        Denuncia denuncia = new Denuncia();
        denuncia.setUsuarioId(usuarioId);
        denuncia.setAnimalId(animalId);
        denuncia.setDenunFecha(denunFecha);
        denuncia.setDenunTipo(denunTipo);
        denuncia.setDenunDescrip(denunDescrip);
        denuncia.setDetalles(detalles);
        return denunciaRepositorio.save(denuncia);

    }

    public List<Denuncia> buscarDenunciaByUser(int idUser) {
        return denunciaRepositorio.findAllByUsuarioId(idUser);
    }

    public List<Denuncia> buscarDenunciaByAnimalId(int id) {
        return denunciaRepositorio.findAllByAnimalId(id);
    }

    public Denuncia actualizar(Denuncia denuncia) {
        return denunciaRepositorio.save(denuncia);
    }

    public List<Denuncia> buscarMaltratoIdMascota(List<Denuncia> listaDenuncias, int idMascota) {
        List<Denuncia> listaDenunciasFiltrada = new ArrayList<>();
        for (Denuncia denuncia : listaDenuncias) {
            if (denuncia.getAnimalId() == idMascota) {
                listaDenunciasFiltrada.add(denuncia);
            }
        }
        return listaDenunciasFiltrada;
    }

    public List<Denuncia> buscarMaltratoFecha(List<Denuncia> listaDenuncias, String fecha) {
        List<Denuncia> listaDenunciasFiltrada = new ArrayList<>();
        for (Denuncia denunciaF : listaDenuncias) {
            if (fecha.equals(denunciaF.getDenunFecha().substring(0, 10))) {
                listaDenunciasFiltrada.add(denunciaF);
            }
        }
        return listaDenunciasFiltrada;
    }

}