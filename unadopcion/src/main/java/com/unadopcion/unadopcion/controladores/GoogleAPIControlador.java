package com.unadopcion.unadopcion.controladores;

import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.modelo.Logeo;
import com.unadopcion.unadopcion.modelo.Usuario;
import com.unadopcion.unadopcion.servicio.LogeoServicio;
import com.unadopcion.unadopcion.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin
@RestController
public class GoogleAPIControlador {
    MiLogger miLogger = new MiLogger(GoogleAPIControlador.class);
    // componente a que se va redirigir depues de autenticacion con Google
    private final String COMPONENTE_URL = "http://localhost:8081/inicio/";

    @Autowired
    private LogeoServicio logeoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;

    @RequestMapping(value = "/autenticar")
    public ResponseEntity<Object> autenticar(@AuthenticationPrincipal OAuth2User user) throws URISyntaxException {
        // Principal que llega de Google
        String nombre = user.getAttribute("name"); // nombre del usuario
        String sub = user.getAttribute("sub");// id de google
        String urlFoto = user.getAttribute("picture");// foto en version URL. Puede cambiar, siempre guardar
        String correo = user.getAttribute("email");

        // crear o refrescar un usuario
        Usuario usuario = null;
        // si usuario no existe con el goodle id entonces crear uno nuevo
        if (!usuarioServicio.usuarioExistePorGoogleId(sub)) {
            usuario = crearUsuarioConGoogle(sub, nombre, urlFoto, correo);
            miLogger.info("Nuevo usuario " + usuario.getUsuarioNombreReal());
        } else {
            // si existe entonces refrescar los datos del usuario
            usuario = usuarioServicio.buscarUsuarioPorGoogleId(sub);
            usuario.setUsuarioNombreReal(nombre);// refrescar nombre en google, puede cambiar
            usuario.setUsuarioUrlFoto(urlFoto);// refrescar foto en google, puede cambiar
            usuarioServicio.guardar(usuario);
            miLogger.info("Usuario existente " + usuario.getUsuarioNombreReal());

        }

        // Armar respuesta de redirecionamiento al controlador inicio en el front
        String rawUrl = COMPONENTE_URL + sub;
        String url = rawUrl.replaceAll(" ", "%20");// replazar espacios en url
        URI comp = new URI(url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(comp);
        miLogger.info("Usuario se a logeado " + nombre + " " + sub + " " + correo + " foto " + urlFoto);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

    }

    // Metodos auxiliares

    private Usuario crearUsuarioConGoogle(String googleId, String usuarioNombreReal, String urlFoto, String correo) {
        // crear logeo primero
        Logeo logeo = logeoServicio.crearLogeo(googleId, "sin_contrasena");
        // crear un usuario con el id del logeo
        Usuario usuario = usuarioServicio.googleCrearUsuario(logeo.getLogeoId(), googleId, usuarioNombreReal, urlFoto,
                correo);
        // poner id de usuario creado en logeo
        logeo.setUsuarioId(usuario.getUsuarioId());
        // guardar cambios a logeo despues de creacion
        logeoServicio.guardar(logeo);

        return usuario;
    }
}
