package com.test.crud.cliente.crud.cliente.mapper;

import org.springframework.stereotype.Component;

import com.test.crud.cliente.crud.cliente.dto.JuegoDTO;
import com.test.crud.cliente.crud.cliente.model.Categoria;
import com.test.crud.cliente.crud.cliente.model.Juego;

@Component
public class JuegoMapper {

    public JuegoDTO toDTO(Juego juego) {
        JuegoDTO dto = new JuegoDTO();
        dto.setIdJuego(juego.getIdJuego());
        dto.setNombreJuego(juego.getNombreJuego());
        dto.setPrecio(juego.getPrecio());
        dto.setStock(juego.getStock());
        dto.setIdCategoria(juego.getCategoria().getIdCategoria());
        return dto;
    }

    public Juego toEntity(JuegoDTO dto, Categoria categoria) {
        Juego juego = new Juego();
        juego.setIdJuego(dto.getIdJuego());
        juego.setNombreJuego(dto.getNombreJuego());
        juego.setPrecio(dto.getPrecio());
        juego.setStock(dto.getStock());
        juego.setCategoria(categoria);
        return juego;
    }
}
