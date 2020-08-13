package com.treinamentoweb.springboot.controller;


import com.treinamentoweb.springboot.model.dto.LojaDTO;
import com.treinamentoweb.springboot.service.LojaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LojaController {

    @Autowired
    private LojaService service;

    @ApiOperation(value = "Listar todas as lojas")
    @GetMapping("/lojas")
    public ResponseEntity buscarTodas(){
        return ResponseEntity.ok().body(service.buscarTodas());
    }

    @ApiOperation(value = "Listar loja por ID")
    @GetMapping("/lojas/{codigo}")
    public ResponseEntity buscarPorId(@PathVariable("codigo") Integer codigo){

        return ResponseEntity.ok().body(service.buscarPorId(codigo));
    }

    @ApiOperation(value = "Cadastrar loja")
    @PostMapping("/lojas")
    public ResponseEntity inserir(@RequestBody LojaDTO dto){
        service.inserir(dto);

        return ResponseEntity.ok().body(dto);
    }

    @ApiOperation(value = "Atualizar loja")
    @PutMapping("/lojas")
    public ResponseEntity atualizar(@RequestBody LojaDTO dto){

        service.atualizar(dto);

        return ResponseEntity.ok().body(dto);
    }

    @ApiOperation(value = "Excluir loja")
    @DeleteMapping("/lojas/{codigo}")
    public ResponseEntity excluirPorId(@PathVariable("codigo") Integer codigo){
        LojaDTO dto = service.excluirPorId(codigo);

        return ResponseEntity.ok().body(dto);
    }

}
