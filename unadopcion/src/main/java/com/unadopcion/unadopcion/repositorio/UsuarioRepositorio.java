package com.unadopcion.unadopcion.repositorio;
import com.unadopcion.unadopcion.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{

    boolean existsByUsuarioNombre(String nombre);
    Usuario getUsuarioByUsuarioNombre(String nombre);
    boolean existsByUsuarioEmail(String email);
    boolean existsByUsuarioId(int usuarioId);
}
