package com.treinamentoweb.springboot.service.bo;


import com.treinamentoweb.springboot.model.dto.LojaDTO;
import com.treinamentoweb.springboot.model.entity.LojaEntity;
import org.springframework.stereotype.Component;

@Component
public class LojaBO {

    public LojaDTO parseToDTO(LojaEntity entity){
        LojaDTO dto = new LojaDTO();

        if(entity == null)
            return dto;

        dto.setCodigo(entity.getCodigo());
        dto.setNome(entity.getNome());
        dto.setLogomarca(entity.getBandeira());
        dto.setCidade(entity.getCidade());

        return dto;
    }


    public LojaEntity parseToEntity(LojaDTO dto, LojaEntity entity){
        if(entity == null)
            entity = new LojaEntity();

        if(dto == null)
            return entity;

        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setBandeira(dto.getLogomarca());
        entity.setCidade(dto.getCidade());

        return entity;
    }

}
