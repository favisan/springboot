package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
public class TbEndereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long idEndereco;

    @Column
    private String dsEndereco;

    @Column
    private String dsCidade;
//
//    @ManyToMany(mappedBy = "enderecos")
//    private List<TbFilial> filiais;

}
