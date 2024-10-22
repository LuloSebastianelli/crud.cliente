package com.test.crud.cliente.crud.cliente.mapper;

import org.springframework.stereotype.Component;

import com.test.crud.cliente.crud.cliente.dto.ClienteDTO;
import com.test.crud.cliente.crud.cliente.model.Cliente;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNombreCliente(cliente.getNombreCliente());
        dto.setEmail(cliente.getEmail());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    public Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.getIdCliente());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }
}

