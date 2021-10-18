package com.gymteam.backend.admin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> myCustomCheck() {
        String message = "Hello from Admin service";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
