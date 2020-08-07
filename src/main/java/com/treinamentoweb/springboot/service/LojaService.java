package com.treinamentoweb.springboot.service;

import com.treinamentoweb.springboot.model.dto.LojaDTO;
import com.treinamentoweb.springboot.model.entity.LojaEntity;
import com.treinamentoweb.springboot.repository.LojaRepository;
import com.treinamentoweb.springboot.service.bo.LojaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LojaService {

    @Autowired
    private LojaRepository repository;

    @Autowired
    private LojaBO lojaBO;

    public List<LojaDTO> buscarTodas(){
        List<LojaEntity> listEntity = repository.findAll();
        List<LojaDTO> listDTO = new ArrayList<>();

        for(LojaEntity entity : listEntity){
            LojaDTO dto = lojaBO.parseToDTO(entity);
            listDTO.add(dto);
        }

        return  listDTO;
    }

    public LojaDTO buscarPorId(Integer codigo){
        return lojaBO.parseToDTO(repository.getOne(codigo));
    }
}
