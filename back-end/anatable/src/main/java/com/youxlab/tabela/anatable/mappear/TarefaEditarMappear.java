package com.youxlab.tabela.anatable.mappear;

import com.youxlab.tabela.anatable.dto.TarefaEditarDTO;
import com.youxlab.tabela.anatable.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , uses = {CategoriaMapper.class})
public interface TarefaEditarMappear {

    @Mapping(source = "categoria" , target = "categoria")
    TarefaEditarDTO toDTO(Tarefa tarefa);

    @Mapping(source = "categoria" , target = "categoria")
    Tarefa toEntity(TarefaEditarDTO dto);


}
