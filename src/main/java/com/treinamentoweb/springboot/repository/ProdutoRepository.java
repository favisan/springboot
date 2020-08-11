package com.treinamentoweb.springboot.repository;

import com.treinamentoweb.springboot.model.entity.TbProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<TbProduto, Long> {
}
