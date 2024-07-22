package com.example.restapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RestControllerTest {

    @GetMapping
    public ResponseEntity<Map<String, Object>> getData(){
        HashMap<String, Object> data = new LinkedHashMap<>();

        data.put("name", "Chandan Kumar");
        data.put("age", 21);
        data.put("class", "BCA");
        data.put("marks", 95.6);

        return ResponseEntity.ok(data);
    }
}
