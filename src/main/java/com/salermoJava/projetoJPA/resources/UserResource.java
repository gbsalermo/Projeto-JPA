package com.salermoJava.projetoJPA.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salermoJava.projetoJPA.entities.User;

//Faz parte da camada de recursos

@RestController //Indico ao framework que se trata de um controlador Rest,
@RequestMapping(value = "/users") //A requeste serve para mapear urls/requisições http para classes ou metodos, definindo caminho

public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){//Uso o Generic ResponseEntity para busca de usuarios
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
		return ResponseEntity.ok().body(u); //Retornar o corpo da resposta do usuario u que acabou de instanciar
	}
}
