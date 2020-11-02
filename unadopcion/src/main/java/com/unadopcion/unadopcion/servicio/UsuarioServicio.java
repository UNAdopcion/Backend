package com.unadopcion.unadopcion.servicio;

import com.unadopcion.unadopcion.modelo.Adopcion;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public Usuario crearUsuario(Usuario user){
         return usuarioRepositorio.save(user);
    }

    @Transactional
    public void editar(Usuario user){
        usuarioRepositorio.save(user);
    }

    @Transactional
    public Usuario crearContacto(){
        Usuario usuario = new Usuario();
        return usuarioRepositorio.save(usuario);
    }


    public boolean existeEmail(String email){
        return usuarioRepositorio.existsByUsuarioEmail(email);
    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Optional<Usuario> buscarUsuario(int id)
    {
        return usuarioRepositorio.findById(id);
    }

    public Usuario buscarUsuario(String nombre){
        return usuarioRepositorio.getUsuarioByUsuarioNombre(nombre);
    }

    public List<Usuario> buscarUsuarios(String nombre){
          return usuarioRepositorio.findAllByUsuarioNombreRealIsLike(nombre);
    }

    public boolean usuarioExiste(String nombre){
        return usuarioRepositorio.existsByUsuarioNombre(nombre);
    }

    public boolean usuarioIdExiste(int  usuarioId){
        return usuarioRepositorio.existsByUsuarioId(usuarioId);
    }

}

