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
                              String animalSexo, int animalEdad, byte[] animalFoto){

        Animal animal = new Animal();
        animal.setRegisId(registroid);
        animal.setAnimNombre(animalNombre);
        animal.setAnimTipo(animalTipo);
        animal.setAnimLugar(animalLugar);
        animal.setAnimDescrip(animalDescripcion);
        animal.setAnimSexo(animalSexo);
        animal.setAnimEdad(animalEdad);
        animal.setAnimFoto(animalFoto);
        return animalRepositorio.save(animal);
    }


    public List<Animal> buscarAnimalPorTipo(String tipo){
        return animalRepositorio.findAllByAnimTipo(tipo);


    }
    public Animal guardar(Animal animal){
        return animalRepositorio.save(animal);
    }
    public Optional buscarAnimalById(int id){
        return Optional.ofNullable(animalRepositorio.findById(id));
    }



}
