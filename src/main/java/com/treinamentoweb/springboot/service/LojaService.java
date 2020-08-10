package com.treinamentoweb.springboot.service;

import com.treinamentoweb.springboot.model.dto.LojaDTO;
import com.treinamentoweb.springboot.model.entity.LojaEntity;
import com.treinamentoweb.springboot.repository.LojaRepository;
import com.treinamentoweb.springboot.service.bo.LojaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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

    public void inserir(LojaDTO dto) {
        LojaEntity entity = lojaBO.parseToEntity(dto, null);
        if(entity.getNome() != null)
            repository.save(entity);
    }

    public void atualizar(LojaDTO dto) {

            LojaEntity entity = repository.getOne(dto.getCodigo()); // select * from tb_loja where codigo = 16
            if(entity != null){
                entity = lojaBO.parseToEntity(dto, entity);
                repository.save(entity); // update tb_loja set nome = 'Osasco C', logomarca = 'drogasil', cidade = 'Osasco' where codigo = 13;
            }
    }

    public LojaDTO excluirPorId(Integer codigo){
        LojaEntity entity = repository.getOne(codigo);
        LojaDTO dto = new LojaDTO();

        if(entity != null) {
            dto = lojaBO.parseToDTO(entity);
            repository.delete(entity);
        }

        return dto;
    }

    public List<LojaEntity> buscarPorNome(String nome){
        return repository.findByNome(nome);
    }
}
