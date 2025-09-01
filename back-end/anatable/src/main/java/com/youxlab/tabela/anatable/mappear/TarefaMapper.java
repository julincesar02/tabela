package com.youxlab.tabela.anatable.mappear;

import com.youxlab.tabela.anatable.dto.TarefaDTO;
import com.youxlab.tabela.anatable.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface TarefaMapper {

    @Mapping(source = "tarefa" , target = "nome")
    @Mapping(source = "status" , target = "statusTarefa")
    Tarefa toEntity(TarefaDTO dto);

    @Mapping(source = "nome" , target = "tarefa")
    @Mapping(source = "statusTarefa" , target = "status")
    TarefaDTO toDTO(Tarefa tarefa);

    List<Tarefa> toEntityList(List<TarefaDTO> tarefaDTOList);

    List<TarefaDTO> toDTOList(List<Tarefa> tarefaList);
}
