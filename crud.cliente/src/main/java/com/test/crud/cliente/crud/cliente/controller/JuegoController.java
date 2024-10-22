package com.test.crud.cliente.crud.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.crud.cliente.crud.cliente.dto.JuegoDTO;
import com.test.crud.cliente.crud.cliente.services.JuegoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    @Autowired
    private JuegoService juegoService;

    @Operation(summary = "Obtener todos los juegos", description = "Recupera los datos de todos los juegos")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Juegos obtenidos con éxito"),
    @ApiResponse(responseCode = "404", description = "No existen juegos creados")
})
    @GetMapping(path = "/all")
    public List<JuegoDTO> getAllJuegos() {
        return juegoService.getAllJuegos();
    }

    @Operation(summary = "Crear un nuevo juego", description = "Agrega un nuevo juego a la base de datos")
@ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Juego creado con éxito"),
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
})
    @PostMapping(path = "/create")
    public ResponseEntity<JuegoDTO> createJuego(
        @Parameter(description = "Datos del nuevo juego", required = true)
        @RequestBody JuegoDTO juegoDTO) {
        JuegoDTO createdJuego = juegoService.createJuego(juegoDTO);
        return ResponseEntity.ok(createdJuego);
    }

    @Operation(summary = "Eliminar un juego", description = "Elimina un juego existente por su ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Juego eliminado con éxito"),
    @ApiResponse(responseCode = "404", description = "Juego no encontrado")
})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJuego(
        @Parameter(description = "ID del juego a eliminar", required = true)
        @PathVariable Long id) {
        juegoService.deleteJuego(id);
        return ResponseEntity.noContent().build(); // Devuelve un 204 No Content si la eliminación fue exitosa
    }

    @Operation(summary = "Actualizar un juego", description = "Actualiza los datos de un juego existente por su ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Juego actualizado con éxito"),
    @ApiResponse(responseCode = "404", description = "Juego no encontrado")
})
    @PutMapping("/put/{id}")
    public ResponseEntity<JuegoDTO> updateJuego(
        @Parameter(description = "ID del juego a actualizar", required = true)
        @PathVariable Long id, 
        @Parameter(description = "Datos actualizados del juego", required = true)
        @RequestBody JuegoDTO juegoDTO) {
        JuegoDTO juegoActualizado = juegoService.updateJuego(id, juegoDTO);
        return ResponseEntity.ok(juegoActualizado); // Devuelve un 200 OK con el juego actualizado
    }
}
