package com.treinamentoweb.springboot.controller;

import com.treinamentoweb.springboot.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @GetMapping("/notas")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(service.listarTodas());
    }

    @GetMapping("/notas/cliente/{idCliente}")
    public ResponseEntity<Object> buscarNfPorTipoProduto(@PathVariable("idCliente") Long idCliente){
        return ResponseEntity.ok().body(service.buscarNfPorIdCliente(idCliente));
    }
}
