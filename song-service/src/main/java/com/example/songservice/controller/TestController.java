package com.example.songservice.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    ResponseEntity<String> getMessage() {
        return ResponseEntity.ok().body(this.message);
    }
}

