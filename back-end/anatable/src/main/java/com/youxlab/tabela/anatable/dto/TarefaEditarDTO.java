package com.youxlab.tabela.anatable.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaEditarDTO {
    private Long id;
    private String tarefa;
    private CategoriaDTO categoria;
    private LocalDate data;

}
