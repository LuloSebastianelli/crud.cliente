package com.test.crud.cliente.crud.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.crud.cliente.crud.cliente.dto.ClienteDTO;

@Service
public class ClienteApiService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://jsonplaceholder.typicode.com/users";  // URL de la API externa

    public ClienteDTO addCliente(ClienteDTO clienteDTO) {
        // Hacemos la llamada POST a la API
        ClienteDTO clienteCreado = restTemplate.postForObject(API_URL, clienteDTO, ClienteDTO.class);
        return clienteCreado;  // Devuelve el cliente creado por la API
    }
}
