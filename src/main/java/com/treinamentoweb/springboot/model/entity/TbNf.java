package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@NamedQuery(name = "buscarNfPorIdCliente", query = "select n from TbNf n where n.cliente.idCliente  =:idCliente")
public class TbNf  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNf;

    @Column
    private Date dtEmissao;

    @Column
    private Long cdFornecedor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private TbCliente cliente;

//    @Column
//    private Long idCliente;

//    @Column
//    private Long cdFilial;

    @ManyToOne
    @JoinColumn(name = "cd_filial")
    private TbFilial filial;

    @Column
    private Long nrNf;

    @Column
    private Long cdTipoNf;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_nf")
    @OneToMany(mappedBy = "nf", cascade = CascadeType.ALL)
    private List<TbNfItem> itens;

}
