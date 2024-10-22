package com.test.crud.cliente.crud.cliente.mapper;

import org.springframework.stereotype.Component;

import com.test.crud.cliente.crud.cliente.dto.CategoriaDTO;
import com.test.crud.cliente.crud.cliente.model.Categoria;

@Component
public class CategoriaMapper {

    public CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNombreCategoria(categoria.getNombreCategoria());
        return dto;
    }

    public Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(dto.getIdCategoria());
        categoria.setNombreCategoria(dto.getNombreCategoria());
        return categoria;
    }
}
