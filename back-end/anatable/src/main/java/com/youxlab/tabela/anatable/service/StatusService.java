package com.youxlab.tabela.anatable.service;

import com.youxlab.tabela.anatable.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {

    public List<String> buscarTodosStatus() {
        List<String> statusTarefas = new ArrayList<>();
        statusTarefas.add(String.valueOf(Status.PENDENTE));
        statusTarefas.add(String.valueOf(Status.CONCLUIDO));
        statusTarefas.add(String.valueOf(Status.TODOS));
        return statusTarefas;
    }
}
