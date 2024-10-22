package com.test.crud.cliente.crud.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.crud.cliente.crud.cliente.dto.ClienteDTO;
import com.test.crud.cliente.crud.cliente.mapper.ClienteMapper;
import com.test.crud.cliente.crud.cliente.model.Cliente;
import com.test.crud.cliente.crud.cliente.repository.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll()
                                .stream()
                                .map(clienteMapper::toDTO)
                                .collect(Collectors.toList());
    }

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(savedCliente);
    }

    public void deleteCliente(Long idCliente) {
        if (clienteRepository.existsById(idCliente)) {
            clienteRepository.deleteById(idCliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    public ClienteDTO updateCliente(Long idCliente, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombreCliente(clienteDTO.getNombreCliente());
        clienteExistente.setEmail(clienteDTO.getEmail());
        clienteExistente.setTelefono(clienteDTO.getTelefono());

        Cliente clienteActualizado = clienteRepository.save(clienteExistente);
        return clienteMapper.toDTO(clienteActualizado);
    }
}


