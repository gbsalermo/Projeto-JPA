package com.salermoJava.projetoJPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salermoJava.projetoJPA.entities.Order;

//Não preciso adicionar uma implementação pois o SpringJPA ja tem uma padrão
public interface OrderRepository extends JpaRepository<Order, Long>{

}
