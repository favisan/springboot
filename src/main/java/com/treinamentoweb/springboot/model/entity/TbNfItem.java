package com.treinamentoweb.springboot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class TbNfItem implements Serializable {

    @Id
    @Column(name = "id_nf")
    private Long idNf;

    @Id
    private Long nrNfItem;

//    @Column
//    private Long cdProduto;

    @Column
    private Long qtItem;

    @Column
    private Double pcIcms;

    @Column
    private BigDecimal vlIcms;

    @Column
    private BigDecimal vlUnitario;

    @ManyToOne
    @JoinColumn(name = "cd_produto")
    private TbProduto produto;

}