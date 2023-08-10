insert into categorias(id, padre_id, descripcion, nombre) values (1, null, 'Categoría raíz', 'Categoría raíz');
insert into categorias(id, padre_id, descripcion, nombre) values (2, 1, 'Categoría 1', 'Categoría 1');
insert into categorias(id, padre_id, descripcion, nombre) values (3, 1, 'Categoría 2', 'Categoría 2');
insert into categorias(id, padre_id, descripcion, nombre) values (4, 1, 'Categoría 3', 'Categoría 3');
insert into categorias(id, padre_id, descripcion, nombre) values (5, 1, 'Categoría 4', 'Categoría 4');
insert into categorias(id, padre_id, descripcion, nombre) values (6, 2, 'Categoría 5', 'Categoría 5');
insert into categorias(id, padre_id, descripcion, nombre) values (7, 2, 'Categoría 6', 'Categoría 6');

insert into productos(id, categoria_id, descripcion, nombre, precio) values (1, 2, 'Producto 1', 'Producto 1', 100);
insert into productos(id, categoria_id, descripcion, nombre, precio) values (2, 2, 'Producto 2', 'Producto 2', 200);
insert into productos(id, categoria_id, descripcion, nombre, precio) values (3, 3, 'Producto 3', 'Producto 3', 300);
insert into productos(id, categoria_id, descripcion, nombre, precio) values (4, 4, 'Producto 4', 'Producto 4', 400);
insert into productos(id, categoria_id, descripcion, nombre, precio) values (5, 5, 'Producto 5', 'Producto 5', 500);
insert into productos(id, categoria_id, descripcion, nombre, precio) values (6, 6, 'Producto 6', 'Producto 6', 600);
insert into productos(id, categoria_id, descripcion, nombre, precio) values (7, 7, 'Producto 7', 'Producto 7', 700);
