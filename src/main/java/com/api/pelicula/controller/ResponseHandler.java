package com.api.pelicula.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generarRespuesta(HttpStatus status, String message){
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("timestamp", new Date());
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }
}
