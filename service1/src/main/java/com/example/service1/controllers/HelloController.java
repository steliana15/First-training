package com.example.service1.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public String hello (@PathVariable String name) {
        return "Hello!," + name;
    }
}