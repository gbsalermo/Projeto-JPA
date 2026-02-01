package com.salermoJava.projetoJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermoJava.projetoJPA.entities.Order;
import com.salermoJava.projetoJPA.entities.User;
import com.salermoJava.projetoJPA.repositories.OrderRepository;


@Service//Registra sua classe como um serviço na camada de serviço do spring
public class OrderService {
	
	//Faço a injeção de dependencia
	@Autowired 
	private OrderRepository repository;
	
	//Metodo para encontrar todo mundo
	public List<Order> findAll(){
		return repository.findAll();
	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id); //Uso o optional pois o valor pode ou nao estar presente, assimn evitando exceção
		return obj.get();
	}

}
