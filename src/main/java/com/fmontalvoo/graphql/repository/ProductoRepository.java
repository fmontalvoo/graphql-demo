package com.fmontalvoo.graphql.repository;

import com.fmontalvoo.graphql.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
