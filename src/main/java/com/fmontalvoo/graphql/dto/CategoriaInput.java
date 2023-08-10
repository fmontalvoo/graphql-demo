package com.fmontalvoo.graphql.dto;

public record CategoriaInput(
        Long id,
        String nombre,
        String descripcion,
        Long padreId
) {
}
