package com.treinamentoweb.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BemVindoController {

    @GetMapping("/home")
    public String obterBoasVindas(){
        return "Bem-vindo ao Spring Boot";
    }


}
