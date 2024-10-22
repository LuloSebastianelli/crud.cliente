package com.test.crud.cliente.crud.cliente.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.crud.cliente.crud.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

        @Query(value = "SELECT * FROM CLIENTES WHERE ID_Cliente = :id", nativeQuery = true)
    Optional<Cliente> getClienteById(@Param("id") Long id);
}
