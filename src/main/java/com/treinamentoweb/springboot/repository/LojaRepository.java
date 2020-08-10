package com.treinamentoweb.springboot.repository;

import com.treinamentoweb.springboot.model.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends JpaRepository<LojaEntity, Integer> {

    List<LojaEntity> findByNome(String nome); //select * from tb_loja where nome = ?

    List<LojaEntity> findByBandeira(String bandeira); // select * from tb_loja where logomarca=  ?

    List<LojaEntity> findByNomeAndBandeiraOrderByCodigo(String nome, String bandeira); // select * from tb_loja where nome = ? and bandeira = ? order by codigo;

}
