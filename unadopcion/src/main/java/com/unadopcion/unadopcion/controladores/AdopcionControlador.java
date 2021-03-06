package com.unadopcion.unadopcion.controladores;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.unadopcion.unadopcion.herramientas.MiLogger;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;
import com.unadopcion.unadopcion.servicio.AdopcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdopcionControlador {

    private MiLogger miLogger = new MiLogger(AdopcionControlador.class);

    @Autowired
    private AdopcionServicio adopcionServicio;



    @RequestMapping(value = "/adoptar", method = RequestMethod.POST, consumes = "application/json", produces = "text/plain")
    public ResponseEntity<Void> crearAdopcion(@RequestBody String json) throws JsonProcessingException, JsonCampoNoExiste {
        //TODO: DEFINIR EL PROCESO DE ADOPCION
       /* JsonLector jsonLector = new JsonLector(json);
        int animalid = Integer.parseInt(jsonLector.getJsonCampo("animalid"));
        int usuarioid = Integer.parseInt(jsonLector.getJsonCampo("usuarioid"));
        //Fecha ahora
        Fecha fecha = new Fecha();

        //verificar animal no ha sido adoptado
        if(!adopcionServicio.animalHaSidoAdoptado(animalid)){

            //crear adopcion
            Adopcion adopcion = adopcionServicio.crearAdopcion(animalid, usuarioid, fecha.getFecha());
            miLogger.info("Solicitud adopcion exitosa animal id:" + animalid);
            return "Solicitud exitosa";
        }else{
            miLogger.cuidado("Se intenta adoptar un animal ya adoptado id:" + animalid);
            return "La mascota ya fue adoptada";
        }*/

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
