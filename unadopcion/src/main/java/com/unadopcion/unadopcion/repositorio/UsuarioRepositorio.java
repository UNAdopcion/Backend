package com.unadopcion.unadopcion.repositorio;
import com.unadopcion.unadopcion.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer>{

    boolean existsByUsuarioNombre(String nombre);
    Usuario getUsuarioByUsuarioNombre(String nombre);
    Usuario getUsuarioByUsuarioGoogleId(String googleId);
    Usuario getUsuarioByUsuarioNombreReal(String nombre);
    Usuario getUsuarioByUsuarioEmail(String email);
    //buscar usuarios por nombre similar
    @Query("SELECT u from Usuario u WHERE u.usuarioNombreReal like %:nombre%" )
    List<Usuario> findAllByUsuarioNombreRealIsLike(String nombre);
    @Query("SELECT u from Usuario u WHERE u.usuarioNombreReal like %:nombre%" )
    Usuario findByUsuarioNombreRealIsLike(String nombre);
    boolean existsByUsuarioGoogleId(String googleId);
    boolean existsByUsuarioEmail(String email);
    boolean existsByUsuarioId(int usuarioId);

    Usuario findFirstByUsuarioGoogleId(String googleId);

}
