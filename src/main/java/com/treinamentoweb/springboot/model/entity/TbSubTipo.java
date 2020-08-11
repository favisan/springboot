package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class TbSubTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdSubTipo;

    @Column
    private String dsSubTipo;

}
