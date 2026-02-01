package com.salermoJava.projetoJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermoJava.projetoJPA.entities.OrderItem;
import com.salermoJava.projetoJPA.repositories.OrderItemRepository;


@Service//Registra sua classe como um serviço na camada de serviço do spring
public class OrderItemService {
	
	//Faço a injeção de dependencia
	@Autowired 
	private OrderItemRepository repository;
	
	//Metodo para encontrar todo mundo
	public List<OrderItem> findAll(){
		return repository.findAll();
	}
	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = repository.findById(id); //Uso o optional pois o valor pode ou nao estar presente, assimn evitando exceção
		return obj.get();
	}

}
