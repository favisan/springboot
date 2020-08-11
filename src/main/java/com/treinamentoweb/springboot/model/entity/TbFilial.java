package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class TbFilial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdFilial;

    @Column
    private String nmFilial;

    @Column
    private String nrCnpj;

}
