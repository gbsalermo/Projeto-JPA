package com.salermoJava.projetoJPA.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.salermoJava.projetoJPA.entities.User;
import com.salermoJava.projetoJPA.repositories.UserRepository;
import com.salermoJava.projetoJPA.services.exceptions.DatabaseException;
import com.salermoJava.projetoJPA.services.exceptions.ResourceNotFoundException;


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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		//O ElseThrow tenta dar o get, se não tiver usuario lança a exceção personalizada
	}

	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id); //Excessão para caso tente deletar um usuario que não existe 
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public User update(Long id, User obj) {
	try {
		User entity = repository.getOne(id); //O getOne mudou, entao pode aparecer como getReferenceById
		updateData(entity, obj);
		return repository.save(entity);
	} catch(EntityNotFoundException e) {
		throw new ResourceNotFoundException(id); 
	}
		
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

		
	}
}
