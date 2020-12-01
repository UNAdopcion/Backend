package com.unadopcion.unadopcion.repositorio;

import com.unadopcion.unadopcion.modelo.Registro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepositorio extends CrudRepository <Registro, Integer>{

    List<Registro> findAllByUsuarioIdIsLike(int personaid);
    Registro findFirstByAnimId(int animid);

}