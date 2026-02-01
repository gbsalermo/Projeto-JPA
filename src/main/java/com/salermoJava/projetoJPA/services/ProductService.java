package com.salermoJava.projetoJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermoJava.projetoJPA.entities.Product;
import com.salermoJava.projetoJPA.repositories.ProductRepository;


@Service//Registra sua classe como um serviço na camada de serviço do spring
public class ProductService {
	
	//Faço a injeção de dependencia
	@Autowired 
	private ProductRepository repository;
	
	//Metodo para encontrar todo mundo
	public List<Product> findAll(){
		return repository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id); //Uso o optional pois o valor pode ou nao estar presente, assimn evitando exceção
		return obj.get();
	}

}
