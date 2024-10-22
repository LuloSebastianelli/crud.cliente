package com.test.crud.cliente.crud.cliente.dto;

import lombok.Data;

@Data
public class CategoriaDTO {
    private Long idCategoria;
    private String nombreCategoria;

    public CategoriaDTO() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}


