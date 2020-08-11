package com.treinamentoweb.springboot.repository;

import com.treinamentoweb.springboot.model.entity.TbFilial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialRepository extends JpaRepository<TbFilial, Long> {
}
