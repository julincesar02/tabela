package com.youxlab.tabela.anatable.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @org.springframework.data.annotation.Transient
    @OneToMany(mappedBy = "categoria")
    private List<Tarefa> tarefas;

    public Categoria(){
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

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(nome, categoria.nome) && Objects.equals(tarefas, categoria.tarefas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, tarefas);
    }

    public Categoria(Long id, String nome, List<Tarefa> tarefas) {
        this.id = id;
        this.nome = nome;
        this.tarefas = tarefas;
    }
}
