package com.salermoJava.projetoJPA.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salermoJava.projetoJPA.entities.User;
import com.salermoJava.projetoJPA.repositories.UserRepository;


@Service//Registra sua classe como um serviço na camada de serviço do spring
public class UserService {
	
	//Faço a injeção de dependencia
	@Autowired 
	private UserRepository repository;
	
	//Metodo para encontrar todo mundo
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //Uso o optional pois o valor pode ou nao estar presente, assimn evitando exceção
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
