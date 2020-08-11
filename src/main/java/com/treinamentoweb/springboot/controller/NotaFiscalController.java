package com.treinamentoweb.springboot.controller;

import com.treinamentoweb.springboot.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaFiscalController {

    @Autowired
    NotaFiscalRepository repository;

    @GetMapping("/notas")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }
}
