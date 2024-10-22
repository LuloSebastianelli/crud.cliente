package com.test.crud.cliente.crud.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crud.cliente.crud.cliente.dto.JuegoDTO;
import com.test.crud.cliente.crud.cliente.mapper.JuegoMapper;
import com.test.crud.cliente.crud.cliente.model.Categoria;
import com.test.crud.cliente.crud.cliente.model.Juego;
import com.test.crud.cliente.crud.cliente.repository.CategoriaRepository;
import com.test.crud.cliente.crud.cliente.repository.JuegoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JuegoService {

    @Autowired
    private JuegoRepository juegoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private JuegoMapper juegoMapper;

    public List<JuegoDTO> getAllJuegos() {
        return juegoRepository.findAll()
            .stream()
            .map(juegoMapper::toDTO)
            .collect(Collectors.toList());
    }

    public JuegoDTO createJuego(JuegoDTO juegoDTO) {
        Categoria categoria = categoriaRepository.findById(juegoDTO.getIdCategoria())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        Juego juego = juegoMapper.toEntity(juegoDTO, categoria);
        Juego savedJuego = juegoRepository.save(juego);
        return juegoMapper.toDTO(savedJuego);
    }

    public void deleteJuego(Long idJuego) {
        if (juegoRepository.existsById(idJuego)) {
            juegoRepository.deleteById(idJuego);
        } else {
            throw new RuntimeException("Juego no encontrado");
        }
    }

    public JuegoDTO updateJuego(Long idJuego, JuegoDTO juegoDTO) {
        Juego juegoExistente = juegoRepository.findById(idJuego)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado"));

        juegoExistente.setNombreJuego(juegoDTO.getNombreJuego());
        juegoExistente.setPrecio(juegoDTO.getPrecio());
        juegoExistente.setStock(juegoDTO.getStock());

        // Verifica si la categoría también debe actualizarse
        if (!juegoExistente.getCategoria().getIdCategoria().equals(juegoDTO.getIdCategoria())) {
            Categoria nuevaCategoria = categoriaRepository.findById(juegoDTO.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            juegoExistente.setCategoria(nuevaCategoria);
        }

        Juego juegoActualizado = juegoRepository.save(juegoExistente);
        return juegoMapper.toDTO(juegoActualizado);
    }
}
