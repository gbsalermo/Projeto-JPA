package com.salermoJava.projetoJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermoJava.projetoJPA.entities.Category;
import com.salermoJava.projetoJPA.repositories.CategoryRepository;


@Service//Registra sua classe como um serviço na camada de serviço do spring
public class CategoryService {
	
	//Faço a injeção de dependencia
	@Autowired 
	private CategoryRepository repository;
	
	//Metodo para encontrar todo mundo
	public List<Category> findAll(){
		return repository.findAll();
	}
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id); //Uso o optional pois o valor pode ou nao estar presente, assimn evitando exceção
		return obj.get();
	}

}
