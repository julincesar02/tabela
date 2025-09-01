package com.youxlab.tabela.anatable.repository;

import com.youxlab.tabela.anatable.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria , Long> {
}
