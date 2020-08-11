package com.treinamentoweb.springboot.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class NotaFiscalDTO {

    private Long idNf;

    private Long cdFornecedor;

    private Long idCliente;

    private Long cdFilial;

    private Long nrNf;

    private Long cdTipoNf;

    private List<NotaFiscalItemDTO> items;


}
