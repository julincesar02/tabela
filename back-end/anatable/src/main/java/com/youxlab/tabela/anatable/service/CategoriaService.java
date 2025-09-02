package com.youxlab.tabela.anatable.service;

import com.youxlab.tabela.anatable.dto.CategoriaDTO;
import com.youxlab.tabela.anatable.mappear.CategoriaMapper;
import com.youxlab.tabela.anatable.model.Categoria;
import com.youxlab.tabela.anatable.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaService(CategoriaRepository repository, CategoriaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public CategoriaDTO salvarCategoria(CategoriaDTO dto) {
        Categoria categoria = mapper.toEntity(dto);
        repository.save(categoria);
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        return dto;
    }

    public List<CategoriaDTO> buscarTodasCategorias() {
        List<Categoria> categoriaList = repository.findAll();
        List<CategoriaDTO> categoriaDTOS = mapper.toDTOList(categoriaList);
        return categoriaDTOS;
    }
}
