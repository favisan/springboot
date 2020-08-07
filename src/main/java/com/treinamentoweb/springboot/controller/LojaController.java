package com.treinamentoweb.springboot.controller;


import com.treinamentoweb.springboot.model.dto.LojaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class LojaController {

    @GetMapping("/lojas")
    public List<LojaDTO> buscarTodas(){
        List<LojaDTO> lista = new ArrayList<>();

        LojaDTO loja = new LojaDTO();
        loja.setCodigo(1);
        loja.setNome("Butanta");
        loja.setLogomarca("Drogasil");
        loja.setCidade("São Paulo");
        loja.setDtEmissao(new Date());
        lista.add(loja);

        return lista;
    }

    @GetMapping("/lojas/{codigo}")
    public LojaDTO buscarPorId(@PathVariable("codigo") Integer codigo){

        System.out.println(codigo);

        LojaDTO loja = new LojaDTO();
        loja.setCodigo(1);
        loja.setNome("Butanta");
        loja.setLogomarca("Drogasil");
        loja.setCidade("São Paulo");
        loja.setDtEmissao(new Date());

        return loja;
    }

}
