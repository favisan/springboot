package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class TbProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdProduto;

    @Column
    private String dsProduto;

    @ManyToOne
    @JoinColumn(name = "cd_tipo_produto")
    private TbTipoProduto tipoProduto;

}
