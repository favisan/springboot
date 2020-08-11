package com.treinamentoweb.springboot.service;

import com.treinamentoweb.springboot.model.dto.NotaFiscalDTO;
import com.treinamentoweb.springboot.model.dto.NotaFiscalItemDTO;
import com.treinamentoweb.springboot.model.entity.TbNf;
import com.treinamentoweb.springboot.model.entity.TbNfItem;
import com.treinamentoweb.springboot.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotaFiscalService {

    @Autowired
    NotaFiscalRepository repository;

    @PersistenceContext
    private EntityManager em;

    public List<NotaFiscalDTO> listarTodas(){

        List<NotaFiscalDTO> listaDTO = new ArrayList<>();
        List<TbNf> listaEntity =  repository.findAll();
        for(TbNf nf : listaEntity){
            NotaFiscalDTO dto = new NotaFiscalDTO();
            dto.setIdNf(nf.getIdNf());
            dto.setNrNf(nf.getNrNf());

            List<NotaFiscalItemDTO> itens = new ArrayList<>();

            for(TbNfItem item : nf.getItens()){
                NotaFiscalItemDTO itDTO = new NotaFiscalItemDTO();
                itDTO.setIdNf(item.getIdNf());
                itDTO.setDsProduto(item.getProduto().getDsProduto());
                itDTO.setNrNfItem(item.getNrNfItem());
                itDTO.setVlProduto(item.getVlUnitario().doubleValue());

                itens.add(itDTO);
            }

            dto.setItems(itens);
            listaDTO.add(dto);
        }

        return listaDTO;
    }

    public List<TbNf> buscarNfPorIdCliente(Long idCliente){
        return em.createNamedQuery("buscarNfPorIdCliente", TbNf.class).setParameter("idCliente", idCliente).getResultList();
    }
}
