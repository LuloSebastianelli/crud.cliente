package com.test.crud.cliente.crud.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.crud.cliente.crud.cliente.model.Categoria;
import com.test.crud.cliente.crud.cliente.services.CategoriaService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private CategoriaService categoriaService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
public void run(String... args) throws Exception {
	
	System.out.println("creamos una categoria");
	this.categoriaService.creandoCategoria(new Categoria("Electrodomesticos"))
}

}

