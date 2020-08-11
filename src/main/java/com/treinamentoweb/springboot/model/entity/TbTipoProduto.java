package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TbTipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdTipoProduto;

    @Column
    private String dsTipoProduto;

    @OneToOne
    @JoinColumn(name = "cd_sub_tipo")
    private TbSubTipo subTipo;
}
