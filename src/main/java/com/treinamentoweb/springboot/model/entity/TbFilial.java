package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

//    @ManyToMany
//    @JoinTable(
//            name = "tb_endereco_filial",
//            joinColumns = @JoinColumn(name = "cd_filial"),
//            inverseJoinColumns = @JoinColumn(name = "id_endereco")
//    )
//    private List<TbEndereco> enderecos;
}
