package com.treinamentoweb.springboot.repository;

import com.treinamentoweb.springboot.model.entity.TbCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<TbCliente, Long> {
}
