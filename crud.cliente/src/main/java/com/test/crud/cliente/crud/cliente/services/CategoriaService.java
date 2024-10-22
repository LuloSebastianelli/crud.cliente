package com.test.crud.cliente.crud.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.crud.cliente.crud.cliente.dto.CategoriaDTO;
import com.test.crud.cliente.crud.cliente.mapper.CategoriaMapper;
import com.test.crud.cliente.crud.cliente.model.Categoria;
import com.test.crud.cliente.crud.cliente.repository.CategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.findAll()
            .stream()
            .map(categoriaMapper::toDTO)
            .collect(Collectors.toList());
    }

    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(savedCategoria);
    }

    public void deleteCategoria(Long idCategoria) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoriaRepository.deleteById(idCategoria);
        } else {
            throw new RuntimeException("Categoría no encontrada");
        }
    }

    public CategoriaDTO updateCategoria(Long idCategoria, CategoriaDTO categoriaDTO) {
        Categoria categoriaExistente = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        categoriaExistente.setNombreCategoria(categoriaDTO.getNombreCategoria());

        Categoria categoriaActualizada = categoriaRepository.save(categoriaExistente);
        return categoriaMapper.toDTO(categoriaActualizada);
    }
}

