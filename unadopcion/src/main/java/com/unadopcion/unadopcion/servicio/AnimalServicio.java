package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Animal;
import com.unadopcion.unadopcion.repositorio.AnimalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServicio {
    @Autowired
    private AnimalRepositorio animalRepositorio;

    @Transactional
    public Animal crearAnimal(int registroid, String animalNombre, String animalTipo,
                              String animalLugar, String animalDescripcion,
                              String animalSexo, int animalEdad, byte[] animalFoto,int animalMicrochipId, String animalEsterilizacion, String animalEstado){

        Animal animal = new Animal();
        animal.setAnimNombre(animalNombre);
        animal.setAnimTipo(animalTipo);
        animal.setAnimLugar(animalLugar);
        animal.setAnimDescrip(animalDescripcion);
        animal.setAnimSexo(animalSexo);
        animal.setAnimEdad(animalEdad);
        animal.setAnimFoto(animalFoto);
        animal.setAnimMicrochipId(animalMicrochipId);
        animal.setAnimEsterilizacion(animalEsterilizacion);
        animal.setAnimEstado(animalEstado);
        return animalRepositorio.save(animal);
    }


    public List<Animal> buscarAnimalPorTipo(String tipo){ return animalRepositorio.findAllByAnimTipo(tipo); }
    public Animal guardar(Animal animal){
        return animalRepositorio.save(animal);
    }
    public Optional buscarAnimalById(int id){
        return Optional.ofNullable(animalRepositorio.findById(id));
    }
    public Animal findFirstByAnimId(int anim_id){
        return animalRepositorio.findFirstByAnimId(anim_id);
    }
    public List<Animal> buscarAnimalPorNombre(String nombre){return animalRepositorio.findAllByAnimNombre(nombre);}
    public boolean animalExiste(int animalId){ return animalRepositorio.existsAnimalByAnimId(animalId); }
    public List<Animal> buscarAnimalPorAnimalId(int animalId){return animalRepositorio.findAllByAnimId(animalId);}
    public Animal buscarAnimalPorID(int animalId){return animalRepositorio.getAnimalByAnimId(animalId);}

}
