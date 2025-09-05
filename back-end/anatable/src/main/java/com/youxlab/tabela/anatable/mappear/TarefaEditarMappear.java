package com.youxlab.tabela.anatable.mappear;

import com.youxlab.tabela.anatable.dto.TarefaEditarDTO;
import com.youxlab.tabela.anatable.model.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CategoriaMapper.class})
public interface TarefaEditarMappear {


    TarefaEditarDTO toDTO(Tarefa tarefa);

    Tarefa toEntity(TarefaEditarDTO dto);


}
