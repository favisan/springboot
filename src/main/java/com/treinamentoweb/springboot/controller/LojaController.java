package com.treinamentoweb.springboot.controller;


import com.treinamentoweb.springboot.model.dto.LojaDTO;
import com.treinamentoweb.springboot.model.entity.LojaEntity;
import com.treinamentoweb.springboot.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class LojaController {

    @Autowired
    private LojaRepository repository;

    @GetMapping("/lojas")
    public List<LojaDTO> buscarTodas(){
        List<LojaEntity> listEntity = repository.findAll();

        List<LojaDTO> listDTO = new ArrayList<>();
        for(LojaEntity entity : listEntity){
            LojaDTO dto = new LojaDTO();
            dto.setCodigo(entity.getCodigo());
            dto.setNome(entity.getNome());
            dto.setLogomarca(entity.getBandeira());
            dto.setCidade(entity.getCidade());

            listDTO.add(dto);
        }

        return listDTO;
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
