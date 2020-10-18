package com.unadopcion.unadopcion.repositorio;
import com.unadopcion.unadopcion.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{

    boolean existsByUsuarioNombre(String nombre);
    Usuario getUsuarioByUsuarioNombre(String nombre);
    boolean existsByUsuarioEmail(String email);
}
