package com.youxlab.tabela.anatable.service;

import com.youxlab.tabela.anatable.dto.TarefaDTO;
import com.youxlab.tabela.anatable.dto.TarefaEditarDTO;
import com.youxlab.tabela.anatable.mappear.CategoriaMapper;
import com.youxlab.tabela.anatable.mappear.TarefaEditarMappear;
import com.youxlab.tabela.anatable.mappear.TarefaMapper;
import com.youxlab.tabela.anatable.model.Categoria;
import com.youxlab.tabela.anatable.model.Tarefa;
import com.youxlab.tabela.anatable.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;
    private final TarefaMapper mapper;
    private final CategoriaMapper categoriaMapper;
    private final TarefaEditarMappear editarMappear;
    public TarefaDTO salvar(TarefaDTO dto) {
        Tarefa tarefa = mapper.toEntity(dto);
        Tarefa tarefaSalva = repository.save(tarefa);
        return mapper.toDTO(tarefaSalva);
    }

    public List<TarefaDTO> buscarTodasTarefas() {
        List<Tarefa> tarefaList = repository.findAll();
        return mapper.toDTOList(tarefaList);
    }

    public TarefaDTO atualizar(Long id, TarefaDTO dto) {
        Optional<Tarefa> tarefa = repository.findById(id);
        if (tarefa.isPresent()){
            tarefa.get().setStatus(dto.getStatus());
            repository.save(tarefa.get());
        }
        return dto;
    }

    public Void deletarDTO(Long id) {
        repository.deleteById(id);
        return null;
    }


    public TarefaEditarDTO atuatizarTabela(Long id, TarefaEditarDTO dto) {
        Optional<Tarefa> tarefa = repository.findById(id);
        if (tarefa.isPresent()){
            tarefa.get().setNome(dto.getTarefa());
            tarefa.get().setData(dto.getData());
            Categoria categoria = categoriaMapper.toEntity(dto.getCategoria());
            tarefa.get().setCategoria(categoria);
            repository.save(tarefa.get());
        }
        dto.setId(id);
        return dto;
    }

//    public List<String> buscarStatus() {
//        List<Tarefa> tarefaList = repository.findAll();
//        List<StatusTarefa> list = tarefaList.stream().map(Tarefa::getStatusTarefa).toList();
//        List<String> status = new ArrayList<>();
//        for (StatusTarefa statusTarefa : list) {
//            status.add(String.valueOf(statusTarefa));
//        }
//        return status;
}

