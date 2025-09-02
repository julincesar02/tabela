package com.youxlab.tabela.anatable.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome" , length = 150 , nullable = false)
    private String nome;

    @Column(name = "data_entrada" , length = 130 , nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tarefa(){}

    public Tarefa(Long id, String nome, LocalDate data, Categoria categoria, Status status) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.categoria = categoria;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id) && Objects.equals(nome, tarefa.nome) && Objects.equals(data, tarefa.data) && Objects.equals(categoria, tarefa.categoria) && status == tarefa.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, data, categoria, status);
    }
}
