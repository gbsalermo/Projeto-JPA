package com.salermoJava.projetoJPA.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salermoJava.projetoJPA.entities.OrderItem;
import com.salermoJava.projetoJPA.services.OrderItemService;

//Faz parte da camada de recursos

@RestController //Indico ao framework que se trata de um controlador Rest,
@RequestMapping(value = "/orderItems") //A requeste serve para mapear urls/requisições http para classes ou metodos, definindo caminho

public class OrderItemResource {
	
	@Autowired
	private OrderItemService service;

	@GetMapping
	public  ResponseEntity<List<OrderItem>> findAll(){//Uso o Generic ResponseEntity para busca de usuarios e chamo o List<OrderItem>
		
		List<OrderItem> list = service.findAll(); //Chamo o service Findall do OrderItem Service
		return ResponseEntity.ok().body(list); //Retornar o corpo da resposta 
	}
	
	@GetMapping(value = "/{id}") //indica que minha requisição vai aceitar um id na url
	public ResponseEntity<OrderItem> findById(@PathVariable Long id){
		OrderItem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
