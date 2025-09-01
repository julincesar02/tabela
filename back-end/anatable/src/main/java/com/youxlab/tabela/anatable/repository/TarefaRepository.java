package com.youxlab.tabela.anatable.repository;

import com.youxlab.tabela.anatable.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa , Long> {
}
