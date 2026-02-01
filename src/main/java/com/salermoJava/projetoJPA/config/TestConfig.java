package com.salermoJava.projetoJPA.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.salermoJava.projetoJPA.entities.Category;
import com.salermoJava.projetoJPA.entities.Order;
import com.salermoJava.projetoJPA.entities.OrderItem;
import com.salermoJava.projetoJPA.entities.Payment;
import com.salermoJava.projetoJPA.entities.Product;
import com.salermoJava.projetoJPA.entities.User;
import com.salermoJava.projetoJPA.entities.enums.OrderStatus;
import com.salermoJava.projetoJPA.repositories.CategoryRepository;
import com.salermoJava.projetoJPA.repositories.OrderItemRepository;
import com.salermoJava.projetoJPA.repositories.OrderRepository;
import com.salermoJava.projetoJPA.repositories.ProductRepository;
import com.salermoJava.projetoJPA.repositories.UserRepository;

@Configuration //Anotação que informa que ela é uma classe de configuração
@Profile("test") 
public class TestConfig implements CommandLineRunner {
	
	//Injeção de dependencia
	@Autowired //Ele que vai fazer essa dependencia, indicando onde a injeção vai ser automaticamente aplicada
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception { 
	//Esse metodo run, de CommandLineRunner, serve para tudo que colocar dentro dele seja imediatamente executado quando a aplicação for iniciada
		//Id nulo pois vai ser gerado pelo proprio banco de dados
		
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),  OrderStatus.WAITING_PAYMENT, u1);
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		 
		userRepository.saveAll(Arrays.asList(u1, u2)); //Uso o saveAll para salvar os objts u1 e u2 como lista usando o Arrays.asList
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		//Salvo os produtos novamente
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1); //No caso de uma relação de um para um, eu nao preciso de outro repositorio
		
			
	}
}
