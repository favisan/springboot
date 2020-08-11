package com.treinamentoweb.springboot.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class TbNfItem implements Serializable {

    @Id
    private Long nrNfItem;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_nf")
    @JsonIgnore
    @Id
    private TbNf nf;
}
