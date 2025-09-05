package com.youxlab.tabela.anatable.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tarefa")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
