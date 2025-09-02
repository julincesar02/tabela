package com.youxlab.tabela.anatable.dto;

import com.youxlab.tabela.anatable.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

public class TarefaDTO {
    private Long id;
    private String tarefa;
    private LocalDate data;
    private Long idCategoria;
    private Status status;

    public TarefaDTO(Long id, String tarefa, LocalDate data, Long idCategoria, Status status) {
        this.id = id;
        this.tarefa = tarefa;
        this.data = data;
        this.idCategoria = idCategoria;
        this.status = status;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getCategoria() {
        return idCategoria;
    }

    public void setCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TarefaDTO tarefaDTO = (TarefaDTO) o;
        return Objects.equals(id, tarefaDTO.id) && Objects.equals(tarefa, tarefaDTO.tarefa) && Objects.equals(data, tarefaDTO.data) && Objects.equals(idCategoria, tarefaDTO.idCategoria) && status == tarefaDTO.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarefa, data, idCategoria, status);
    }
}
