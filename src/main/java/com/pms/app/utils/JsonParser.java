package com.pms.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JsonParser<T> {

    private  final ObjectMapper objectMapper = new ObjectMapper();
    public String convertToJsonString(T obj) throws JsonProcessingException {
         String ansJson = objectMapper.writeValueAsString(obj);
         return ansJson;
    }

    public T StringToJson(String jsonString , Class<T> clazz) throws JsonProcessingException{
          T obj = objectMapper.readValue(jsonString , clazz);
          return obj;
    }

    public T StringToJsonByTypeRef(String jsonString , TypeReference<T> typeRef) throws JsonProcessingException{
        T obj = objectMapper.readValue(jsonString , typeRef);
        return obj;
    }
    public void getErrorResponse (HttpServletResponse response , int status , String message) throws  JsonProcessingException , IOException {
           response.setStatus(status);
           response.setContentType("application/json");

           Map<String , Object> errorObject = new HashMap<>();
           errorObject.put("status" , status);
           errorObject.put("error" , message );

           String json = objectMapper.writeValueAsString(errorObject);

           response.getWriter().write(json);
    };
}
