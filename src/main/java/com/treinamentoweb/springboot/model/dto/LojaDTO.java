package com.treinamentoweb.springboot.model.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LojaDTO {

    private Integer codigo;

    private String nome;

    private String logomarca;

    private String cidade;

    private Date dtEmissao;


}
