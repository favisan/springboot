package com.treinamentoweb.springboot.model.dto;


import lombok.Data;

@Data
public class NotaFiscalItemDTO {

    private Long idNf;

    private Long nrNfItem;

    private String dsProduto;

    private Double vlProduto;
}
