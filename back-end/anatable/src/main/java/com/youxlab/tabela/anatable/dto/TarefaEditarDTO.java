package com.youxlab.tabela.anatable.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;


public class TarefaEditarDTO {
    private Long id;
    private String tarefa;
    private CategoriaDTO categoria;
    private LocalDate data;

    public TarefaEditarDTO(){}

    public TarefaEditarDTO(Long id, String tarefa, CategoriaDTO categoria, LocalDate data) {
        this.id = id;
        this.tarefa = tarefa;
        this.categoria = categoria;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TarefaEditarDTO that = (TarefaEditarDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(tarefa, that.tarefa) && Objects.equals(categoria, that.categoria) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarefa, categoria, data);
    }
}
