package com.treinamentoweb.springboot.model.dto;


import lombok.Data;

@Data
public class NotaFiscalItemDTO {

    private Long idNf;

    private Long nrNfItem;

    private Long cdProduto;

    private Double vlProduto;
}
