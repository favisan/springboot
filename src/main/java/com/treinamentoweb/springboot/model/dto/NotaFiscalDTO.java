package com.treinamentoweb.springboot.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class NotaFiscalDTO {

    private Long idNf;

    List<NotaFiscalItemDTO> items;

    private Long nrNf;


}
