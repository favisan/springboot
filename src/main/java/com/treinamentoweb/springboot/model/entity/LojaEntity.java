package com.treinamentoweb.springboot.model.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "tb_loja")
@Data
public class LojaEntity {

    @Id
    @GeneratedValue
    private Integer codigo;

    @Column
    private String nome;

    @Column(name = "logomarca")
    private String bandeira;

    @Column
    private String cidade;

}