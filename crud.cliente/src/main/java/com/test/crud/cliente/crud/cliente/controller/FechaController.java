package com.test.crud.cliente.crud.cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.test.crud.cliente.crud.cliente.services.FechaService;
import com.test.crud.cliente.crud.utils.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
// @RequestMapping("/")
public class FechaController {

    @Autowired
    private FechaService fechaService;

    @GetMapping("/fecha")
    public ResponseEntity<?> getFecha() {
        ApiResponse apiResponse = new ApiResponse("Hora acutal: " + fechaService.getFechaActual(),
                "Cantidad de invocaciones: " + fechaService.getCantidadInvocaciones());
        return ResponseEntity.ok(apiResponse);
    }

}