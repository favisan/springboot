package com.treinamentoweb.springboot.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class TbCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column
    private String nmCliente;

    @Column
    private String nrCpf;

    @Column
    private String nrCnpj;

    @Column
    private Date dtCadastro;

    @ManyToMany
    @JoinTable(name = "tb_endereco_cliente",
        joinColumns = @JoinColumn(name = "id_cliente"),
        inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private List<TbEndereco> enderecos;

}
