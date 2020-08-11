package com.treinamentoweb.springboot.service;

import com.treinamentoweb.springboot.model.dto.NotaFiscalDTO;
import com.treinamentoweb.springboot.model.dto.NotaFiscalItemDTO;
import com.treinamentoweb.springboot.model.entity.TbNf;
import com.treinamentoweb.springboot.model.entity.TbNfItem;
import com.treinamentoweb.springboot.repository.ClienteRepository;
import com.treinamentoweb.springboot.repository.FilialRepository;
import com.treinamentoweb.springboot.repository.NotaFiscalRepository;
import com.treinamentoweb.springboot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

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
//                itDTO.setIdNf(item.getIdNf());
                itDTO.setCdProduto(item.getProduto().getCdProduto());
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

    public TbNf inserir(NotaFiscalDTO nfDTO){
        TbNf nfEntity = new TbNf();
        nfEntity.setCdFornecedor(nfDTO.getCdFornecedor());
        nfEntity.setCdTipoNf(nfDTO.getCdTipoNf());
        nfEntity.setCliente(clienteRepository.getOne(nfDTO.getIdCliente()));
        nfEntity.setFilial(filialRepository.getOne(nfDTO.getCdFilial()));
        nfEntity.setNrNf(nfDTO.getNrNf());

        List<TbNfItem> itemsEntity = new ArrayList<>();
        for(NotaFiscalItemDTO itemDTO : nfDTO.getItems()){
            TbNfItem itEntity = new TbNfItem();
            itEntity.setNrNfItem(itemDTO.getNrNfItem());
            itEntity.setProduto(produtoRepository.getOne(itemDTO.getCdProduto()));
            itEntity.setVlUnitario(new BigDecimal(itemDTO.getVlProduto()));

            itEntity.setNf(nfEntity);
            itemsEntity.add(itEntity);
        }

        nfEntity.setItens(itemsEntity);

        return repository.save(nfEntity);
    }
}
