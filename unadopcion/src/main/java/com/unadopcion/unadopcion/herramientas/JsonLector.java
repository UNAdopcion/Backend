package com.unadopcion.unadopcion.herramientas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unadopcion.unadopcion.herramientas.excepciones.JsonCampoNoExiste;

public  class JsonLector {

    private  JsonNode jsonNodo;

    public  JsonLector(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        jsonNodo = objectMapper.readTree(json);

    }

    public  String getJsonCampo(String campo) throws JsonCampoNoExiste {
        if(jsonNodo.has(campo))
           return jsonNodo.get(campo).asText().trim();
        else
            throw new JsonCampoNoExiste("El campo de Json " + campo +  " no existe");


    }
}
