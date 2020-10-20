package com.unadopcion.unadopcion.repositorio;

import java.util.List;

import com.unadopcion.unadopcion.modelo.Denuncia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepositorio extends CrudRepository<Denuncia, Integer>{

List <Denuncia> findAllByUsuarioId(int usuarioId);


}