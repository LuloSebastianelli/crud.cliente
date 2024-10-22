package com.test.crud.cliente.crud.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.crud.cliente.crud.cliente.dto.CategoriaDTO;
import com.test.crud.cliente.crud.cliente.services.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Obtener todas las categorias", description = "Recupera los datos de todas las categorias")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Categorías obtenidas con éxito"),
    @ApiResponse(responseCode = "404", description = "No existen categorias")
})
    @GetMapping(path = "/all")
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @Operation(summary = "Crear nueva categoría", description = "Agrega una nueva categoría a la base de datos")
@ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Categoría creada con éxito"),
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
})
    @PostMapping(path = "/create")
    public ResponseEntity<CategoriaDTO> createCategoria(
        @Parameter(description = "Datos de la nueva categoría", required = true)
        @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO createdCategoria = categoriaService.createCategoria(categoriaDTO);
        return ResponseEntity.ok(createdCategoria);
    }

    @Operation(summary = "Eliminar categoría", description = "Elimina una categoría existente por su ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Categoría eliminada con éxito"),
    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoria(
        @Parameter(description = "ID de la categoría a eliminar", required = true)
        @PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build(); // Devuelve un 204 No Content si la eliminación fue exitosa
    }

    @Operation(summary = "Actualizar categoría existente", description = "Actualiza los datos de una categoría por su ID")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Categoría actualizada con éxito"),
    @ApiResponse(responseCode = "404", description = "Categoría no encontrada")
})
    @PutMapping("/put/{id}")
    
    
    public ResponseEntity<CategoriaDTO> updateCategoria(
        @Parameter(description = "ID de la categoría a actualizar", required = true)
        @PathVariable Long id, 
        @Parameter(description = "Datos actualizados de la categoría", required = true)
        @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaActualizada = categoriaService.updateCategoria(id, categoriaDTO);
        return ResponseEntity.ok(categoriaActualizada); // Devuelve un 200 OK con la categoría actualizada
    }
}

