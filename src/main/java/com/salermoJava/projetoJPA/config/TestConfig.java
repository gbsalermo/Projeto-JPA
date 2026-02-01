package com.salermoJava.projetoJPA.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.salermoJava.projetoJPA.entities.Order;
import com.salermoJava.projetoJPA.entities.User;
import com.salermoJava.projetoJPA.entities.enums.OrderStatus;
import com.salermoJava.projetoJPA.repositories.OrderRepository;
import com.salermoJava.projetoJPA.repositories.UserRepository;

@Configuration //Anotação que informa que ela é uma classe de configuração
@Profile("test") 
public class TestConfig implements CommandLineRunner {
	
	//Injeção de dependencia
	@Autowired //Ele que vai fazer essa dependencia, indicando onde a injeção vai ser automaticamente aplicada
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception { 
	//Esse metodo run, de CommandLineRunner, serve para tudo que colocar dentro dele seja imediatamente executado quando a aplicação for iniciada
		//Id nulo pois vai ser gerado pelo proprio banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),  OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2)); //Uso o saveAll para salvar os objts u1 e u2 como lista usando o Arrays.asList
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

			
	}
}
