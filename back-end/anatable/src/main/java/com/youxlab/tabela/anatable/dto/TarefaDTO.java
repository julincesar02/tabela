package com.youxlab.tabela.anatable.dto;

import com.youxlab.tabela.anatable.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {
    private Long id;
    private String tarefa;
    private LocalDate data;
    private CategoriaDTO categoria;
    private Status status;
}
