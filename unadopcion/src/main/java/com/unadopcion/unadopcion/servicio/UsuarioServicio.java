package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public Usuario crearUsuario(int logeoId, String usuarioNombre,
                                String usuarioCorreo,
                                String usuarioTelefono){
         String ninguno = "";
         Usuario usuario = new Usuario();
         usuario.setLogeoId(logeoId);
         usuario.setUsuarioNombre(usuarioNombre);
         usuario.setUsuarioTelefono(usuarioTelefono);
         usuario.setUsuarioRol(ninguno);
         usuario.setUsuarioPuntos(0);
         usuario.setUsuarioEmail(usuarioCorreo);
         usuario.setUsuarioLugar(ninguno);
         usuario.setUsuarioInfo(ninguno);
         return usuarioRepositorio.save(usuario);

    }

    public Optional<Usuario> buscarUsuario(int id)
    {
        return usuarioRepositorio.findById(id);
    }
}

