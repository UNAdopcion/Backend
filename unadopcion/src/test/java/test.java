import com.unadopcion.unadopcion.UnadopcionApplication;
import com.unadopcion.unadopcion.controladores.SolicitudControlador;
import com.unadopcion.unadopcion.modelo.*;
import com.unadopcion.unadopcion.pojo.SolicitudConsultaPOJO;
import com.unadopcion.unadopcion.repositorio.LogeoRepositorio;
import com.unadopcion.unadopcion.repositorio.UsuarioRepositorio;
import com.unadopcion.unadopcion.servicio.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthEditorPaneUI;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = UnadopcionApplication.class)
class test {

    @Autowired
    @Mock
    private UsuarioServicio usuarioServicio;
    @Autowired
    @Mock
    private AnimalServicio animalServicio;
    @Autowired
    @Mock
    private SolicitudServicio solicitudServicio;
    @Autowired
    @Mock
    private RegistroServicio registroServicio;
    @Autowired
    @Mock
    private LogeoServicio logeoServicio;

    @Mock
    private LogeoRepositorio logeoRepositorio;
    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    @InjectMocks
    @Autowired
    private SolicitudControlador solicitudControlador;

    boolean ejecucion = true;

    @BeforeEach
    public void datos() {

        if (!ejecucion) {
            return;
        } else {
            int[] Ids = new int[3];
            for (int i = 1; i < 4; i++) {
                Logeo logeo = new Logeo();
                //logeo.setLogeoId(i);
                logeo.setLogeoContra(String.valueOf(i));
                logeo.setLogeoNombre(String.valueOf(i));
                logeo = logeoServicio.guardar(logeo);

                Usuario usuario = new Usuario();
                //usuario.setUsuarioId(i);
                usuario.setLogeoId(logeo.getLogeoId());
                usuario.setUsuarioNombreReal(String.valueOf(i));
                usuario.setUsuarioGoogleId(String.valueOf(i));
                usuario.setUsuarioUrlFoto(String.valueOf(i));
                usuario.setUsuarioNombre(String.valueOf(i));
                usuario.setUsuarioRol(String.valueOf(i));
                usuario.setUsuarioPuntos(i);
                usuario.setUsuarioTelefono(String.valueOf(i));
                usuario.setUsuarioLugar(String.valueOf(i));
                usuario.setUsuarioEmail(String.valueOf(i));
                usuario.setUsuarioInfo(String.valueOf(i));
                usuario = usuarioServicio.guardar(usuario);
                Ids[i - 1] = usuario.getUsuarioId();
                //System.out.println(logeo.getLogeoId() + " " + usuario.getUsuarioId());
            }

            for (int i = 1; i < 3; i++) {
                Animal animal = new Animal();
                //animal.setAnimId(i);
                animal.setAnimNombre(String.valueOf(i));
                animal.setAnimTipo(String.valueOf(i));
                animal.setAnimLugar(String.valueOf(i));
                animal.setAnimDescrip(String.valueOf(i));
                animal.setAnimFoto(new byte[5]);
                animal.setAnimEdad(i);
                animal.setAnimSexo(String.valueOf(i));
                animal.setAnimMicrochipId(i);
                animal.setAnimEsterilizacion(String.valueOf(i));
                animal.setAnimEstado(String.valueOf(i));
                animal = animalServicio.guardar(animal);

                Registro registro = new Registro();
                //registro.setRegisId(i);
                registro.setUsuarioId(Ids[i - 1]);
                registro.setAnimId(animal.getAnimId());
                registro.setRegisFecha(String.valueOf(i));
                registro = registroServicio.guardar(registro);
                //System.out.println(animal.getAnimId() + " " + registro.getRegisId());
            }
            ejecucion = !ejecucion;
        }
    }

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> UnadopcionApplication.main(new String[]{}));
    }

    @Test
    void RealizarSolicitudCreated() {
        ResponseEntity<Void> responseEntity = solicitudControlador.RealizarSolicitud(7, "3");
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        ResponseEntity<Void> responseEntity2 = solicitudControlador.RealizarSolicitud(9, "3");
        assertEquals(HttpStatus.CREATED, responseEntity2.getStatusCode());
        ResponseEntity<Void> responseEntity3 = solicitudControlador.RealizarSolicitud(9, "1");
        assertEquals(HttpStatus.CREATED, responseEntity3.getStatusCode());
    }
/*
    @Test
    void RealizarSolicitudOk() {
        ResponseEntity<Void> responseEntity = solicitudControlador.RealizarSolicitud(7, "3");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ResponseEntity<Void> responseEntity2 = solicitudControlador.RealizarSolicitud(9, "3");
        assertEquals(HttpStatus.OK, responseEntity2.getStatusCode());
        ResponseEntity<Void> responseEntity3 = solicitudControlador.RealizarSolicitud(9, "1");
        assertEquals(HttpStatus.OK, responseEntity3.getStatusCode());
    }
*/
    @Test
    void cancelarSolicitudAccepted() {
        ResponseEntity<Void> responseEntity = solicitudControlador.cancelarSolicitud(12);
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
    }

    @Test
    void cancelarSolicitudConflict() {
        ResponseEntity<Void> responseEntity = solicitudControlador.cancelarSolicitud(12);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
    }

    @Test
    void rechazarSolicitudAccepted() {
        Solicitud solicitud = solicitudServicio.findFirstById(12);
        System.out.println(solicitud.getEstado());
        ResponseEntity<Void> responseEntity = solicitudControlador.rechazarSolicitud(13);
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
    }

    @Test
    void rechazarSolicitudConflict() {
        ResponseEntity<Void> responseEntity = solicitudControlador.rechazarSolicitud(13);
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
    }

    @Test
    void aceptarSolicitudAccepted() {
        ResponseEntity<Void> responseEntity = solicitudControlador.aceptarSolicitud(11, "");
        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
    }

    @Test
    void aceptarSolicitudConflict() {
        ResponseEntity<Void> responseEntity = solicitudControlador.aceptarSolicitud(11, "");
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
    }

    void ConsultarPendiente() {
        SolicitudConsultaPOJO pojo = new SolicitudConsultaPOJO();
        pojo.setPersonaid("1");
        List<SolicitudConsultaPOJO> list = solicitudControlador.ConsultarPendiente(pojo);
        assertNotNull(list);
    }
}
