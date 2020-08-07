package com.treinamentoweb.springboot.repository;

import com.treinamentoweb.springboot.model.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends JpaRepository<LojaEntity, Integer> {


}
