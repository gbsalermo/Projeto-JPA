package com.salermoJava.projetoJPA.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salermoJava.projetoJPA.entities.Product;
import com.salermoJava.projetoJPA.services.ProductService;

//Faz parte da camada de recursos

@RestController //Indico ao framework que se trata de um controlador Rest,
@RequestMapping(value = "/products") //A requeste serve para mapear urls/requisições http para classes ou metodos, definindo caminho

public class ProductResource {
	
	@Autowired
	private ProductService service;

	@GetMapping
	public  ResponseEntity<List<Product>> findAll(){//Uso o Generic ResponseEntity para busca de usuarios e chamo o List<Product>
		
		List<Product> list = service.findAll(); //Chamo o service Findall do Product Service
		return ResponseEntity.ok().body(list); //Retornar o corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") //indica que minha requisição vai aceitar um id na url
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
