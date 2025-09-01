package com.youxlab.tabela.anatable.mappear;

import com.youxlab.tabela.anatable.dto.CategoriaDTO;
import com.youxlab.tabela.anatable.model.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaDTO dto);

    CategoriaDTO toDTO(Categoria categoria);

    List<Categoria> toEntityList(List<CategoriaDTO> categoriaDTOSList);

    List<CategoriaDTO> toDTOList(List<Categoria> categoriaList);
}
