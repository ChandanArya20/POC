package com.example.restapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class RestControllerTest2 {

    @GetMapping
    public ResponseEntity<?> getData(){

        var student = Map.of(
                "name","Chandan Kumar",
                "age",20,
                "class", "12th",
                "Roll", 5
        );

        /*
        * var student = {
        *   name:"Chandan Kumar"
        *   age:20
        *   class:"12th"
        * }
        */

        return ResponseEntity.ok(student);
    }
}
