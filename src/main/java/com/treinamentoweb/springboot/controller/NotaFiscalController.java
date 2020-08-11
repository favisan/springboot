package com.treinamentoweb.springboot.controller;

import com.treinamentoweb.springboot.model.dto.NotaFiscalDTO;
import com.treinamentoweb.springboot.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/notas")
    public ResponseEntity<Object> salvarNotaFiscal(@RequestBody NotaFiscalDTO notaFiscalDTO){
        return ResponseEntity.ok().body(service.inserir(notaFiscalDTO));
    }
}
