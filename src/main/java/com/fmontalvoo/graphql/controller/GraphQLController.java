package com.fmontalvoo.graphql.controller;

import com.fmontalvoo.graphql.dto.CategoriaInput;
import com.fmontalvoo.graphql.dto.ProductoInput;
import com.fmontalvoo.graphql.model.Categoria;
import com.fmontalvoo.graphql.model.Producto;
import com.fmontalvoo.graphql.repository.CategoriaRepository;
import com.fmontalvoo.graphql.repository.ProductoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public GraphQLController(CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @QueryMapping
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @QueryMapping
    public Categoria getCategoria(@Argument Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No se encontró la categoría con id: %d", id)));
    }

    @QueryMapping
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @QueryMapping
    public Producto getProducto(@Argument Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No se encontró el producto con id: %d", id)));
    }

    @MutationMapping
    public Producto crearProducto(@Argument ProductoInput input) {
        Producto producto = new Producto();

        producto.setNombre(input.nombre());
        producto.setDescripcion(input.descripcion());
        producto.setPrecio(input.precio());
        producto.setCategoria(new Categoria(input.categoriaId()));

        return productoRepository.save(producto);
    }

    @MutationMapping
    public Producto actualizarProducto(@Argument Long id, @Argument ProductoInput input) {

        return productoRepository.findById(id)
                .stream().map(producto -> {
                    producto.setNombre(input.nombre());
                    producto.setDescripcion(input.descripcion());
                    producto.setPrecio(input.precio());
                    producto.setCategoria(new Categoria(input.categoriaId()));
                    return productoRepository.save(producto);
                }).findFirst().orElseThrow(
                        () -> new RuntimeException(String.format("No se encontró el producto con id: %d", id))
                );
    }

    @MutationMapping
    public void eliminarProducto(@Argument Long id) {
        productoRepository.deleteById(id);
    }

    @MutationMapping
    public Categoria crearCategoria(@Argument CategoriaInput input) {
        Categoria categoria = new Categoria();

        categoria.setNombre(input.nombre());
        categoria.setDescripcion(input.descripcion());
        if (input.padreId() != null)
            categoria.setPadre(new Categoria(input.padreId()));

        return categoriaRepository.save(categoria);
    }

    @MutationMapping
    public Categoria actualizarCategoria(@Argument Long id, @Argument CategoriaInput input) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNombre(input.nombre());
                    categoria.setDescripcion(input.descripcion());
                    if (input.padreId() != null)
                        categoria.setPadre(new Categoria(input.padreId()));
                    return categoriaRepository.save(categoria);
                }).orElseThrow(
                        () -> new RuntimeException(String.format("No se encontró la categoría con id: %d", id))
                );
    }

    @MutationMapping
    public void eliminarCategoria(@Argument Long id) {
        categoriaRepository.deleteById(id);
    }

}
