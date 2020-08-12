package com.treinamentoweb.springboot.controller;

import com.treinamentoweb.springboot.model.dto.NotaFiscalDTO;
import com.treinamentoweb.springboot.model.dto.ResultData;
import com.treinamentoweb.springboot.model.entity.TbNf;
import com.treinamentoweb.springboot.service.NotaFiscalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @ApiOperation(value = "Listar todas as notas")
    @GetMapping("/notas")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(service.listarTodas());
    }

    @ApiOperation(value = "Listar notas por idCliente")
    @GetMapping("/notas/cliente/{idCliente}")
    public ResponseEntity<Object> buscarNfPorTipoProduto(@PathVariable("idCliente") Long idCliente){
        return ResponseEntity.ok().body(service.buscarNfPorIdCliente(idCliente));
    }

    @ApiOperation(value = "Gera nota fiscal")
    @PostMapping("/notas")
    public ResponseEntity<Object> salvarNotaFiscal(@RequestBody NotaFiscalDTO notaFiscalDTO){
        ResultData resultData = null;
        if(notaFiscalDTO.getCdFilial() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Campo: cdFilial não informado!");
        else if(notaFiscalDTO.getIdCliente() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Campo: idCliente não informado!");

        if(resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                TbNf notaFiscal = service.inserir(notaFiscalDTO);
                resultData = new ResultData<TbNf>(HttpStatus.OK.value(), "Nota Fiscal registrada com sucesso!", notaFiscal);
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            }catch(Exception e){
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar NF", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
            }
        }
    }
}
