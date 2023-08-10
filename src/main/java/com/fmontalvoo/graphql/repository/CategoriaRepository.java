package com.fmontalvoo.graphql.repository;

import com.fmontalvoo.graphql.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
