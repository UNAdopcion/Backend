package com.unadopcion.unadopcion.herramientas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAPOJO {

    ObjectMapper objectMapper;

    public JsonAPOJO(){
        objectMapper = new ObjectMapper();
    }

    public Object getPOJO(String json, Class clase) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return objectMapper.treeToValue(jsonNode, clase);
    }
}
