package com.test.crud.cliente.crud.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.crud.cliente.crud.cliente.dto.ClienteDTO;
import com.test.crud.cliente.crud.cliente.services.ClienteApiService;
import com.test.crud.cliente.crud.cliente.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteApiService clienteApiService;

    @Operation(summary = "Obtener todos los clientes", description = "Recupera los datos de todos los clientes")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Clientes obtenidos con éxito"),
    @ApiResponse(responseCode = "404", description = "No existen clientes")
})
    @GetMapping(path= "/all")
    public List<ClienteDTO> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @Operation(summary = "Crear un nuevo cliente", description = "Agrega un nuevo cliente a la base de datos")
@ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Cliente creado con éxito"),
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
})
    @PostMapping(path = "/create")
    public ResponseEntity<ClienteDTO> createCliente(
        @Parameter(description = "Datos del nuevo cliente", required = true)
        @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO createdCliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.ok(createdCliente);
    }

    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente existente por su ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Cliente eliminado con éxito"),
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCliente(
        @Parameter(description = "ID del cliente a eliminar", required = true)
        @PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build(); // Devuelve un 204 No Content si la eliminación fue exitosa
    }

    @Operation(summary = "Actualizar un cliente", description = "Actualiza los datos de un cliente existente por su ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Cliente actualizado con éxito"),
    @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
})
    @PutMapping("/put/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(
        @Parameter(description = "ID del cliente a actualizar", required = true)
        @PathVariable Long id, 
        @Parameter(description = "Datos actualizados del cliente", required = true)
        @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteActualizado = clienteService.updateCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteActualizado); // Devuelve un 200 OK con el cliente actualizado
    }

    @Operation(summary = "Crear un nuevo cliente de una api externa", description = "Agrega un nuevo cliente a la base de datos desde una api externa")
@ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Cliente creado con éxito"),
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
})
    @PostMapping("/agregar-externo")
    public ResponseEntity<ClienteDTO> agregarCliente(
        @Parameter(description = "Datos del nuevo cliente", required = true)
        @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteCreado = clienteApiService.addCliente(clienteDTO);
        return ResponseEntity.ok(clienteCreado);  // Devuelve el cliente creado por la API externa
    }
}
