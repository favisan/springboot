package com.treinamentoweb.springboot.repository;

import com.treinamentoweb.springboot.model.entity.TbNf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<TbNf, Long> {


}
