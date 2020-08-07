package com.treinamentoweb.springboot.controller;


import com.treinamentoweb.springboot.model.dto.LojaDTO;
import com.treinamentoweb.springboot.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LojaController {

    @Autowired
    private LojaService service;

    @GetMapping("/lojas")
    public List<LojaDTO> buscarTodas(){
        return service.buscarTodas();
    }

    @GetMapping("/lojas/{codigo}")
    public LojaDTO buscarPorId(@PathVariable("codigo") Integer codigo){
        return service.buscarPorId(codigo);
    }




}
