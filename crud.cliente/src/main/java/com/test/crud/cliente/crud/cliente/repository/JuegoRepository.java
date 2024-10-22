package com.test.crud.cliente.crud.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.crud.cliente.crud.cliente.model.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
}
