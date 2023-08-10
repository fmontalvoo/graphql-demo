package com.fmontalvoo.graphql.dto;

public record ProductoInput(
        Long id,
        String nombre,
        String descripcion,
        Double precio,
        Long categoriaId
) {
}
