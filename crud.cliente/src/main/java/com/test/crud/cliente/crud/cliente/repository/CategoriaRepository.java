package com.test.crud.cliente.crud.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.crud.cliente.crud.cliente.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

