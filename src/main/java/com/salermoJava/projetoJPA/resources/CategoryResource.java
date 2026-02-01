package com.salermoJava.projetoJPA.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salermoJava.projetoJPA.entities.Category;
import com.salermoJava.projetoJPA.services.CategoryService;

//Faz parte da camada de recursos

@RestController //Indico ao framework que se trata de um controlador Rest,
@RequestMapping(value = "/categories") //A requeste serve para mapear urls/requisições http para classes ou metodos, definindo caminho

public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping
	public  ResponseEntity<List<Category>> findAll(){//Uso o Generic ResponseEntity para busca de usuarios e chamo o List<Category>
		
		List<Category> list = service.findAll(); //Chamo o service Findall do Category Service
		return ResponseEntity.ok().body(list); //Retornar o corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") //indica que minha requisição vai aceitar um id na url
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
