package com.salermoJava.projetoJPA.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salermoJava.projetoJPA.entities.User;
import com.salermoJava.projetoJPA.services.UserService;


//Faz parte da camada de recursos

@RestController //Indico ao framework que se trata de um controlador Rest,
@RequestMapping(value = "/users") //A requeste serve para mapear urls/requisições http para classes ou metodos, definindo caminho

public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public  ResponseEntity<List<User>> findAll(){//Uso o Generic ResponseEntity para busca de usuarios e chamo o List<user>
		
		List<User> list = service.findAll(); //Chamo o service Findall do User Service
		return ResponseEntity.ok().body(list); //Retornar o corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") //indica que minha requisição vai aceitar um id na url
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//Uso o URI que serve para identificar e localizar(Recursos/entidades) funcionando como uma etiqueta
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build(); //O NoContente vai retornar uma resposa vazia e permitir o 204
	}
}
