package com.treinamentoweb.springboot.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class TbCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nmCliente;

    @Column
    private String nrCpf;

    @Column
    private String nrCnpj;

    @Column
    private Date dtCadastro;


}
