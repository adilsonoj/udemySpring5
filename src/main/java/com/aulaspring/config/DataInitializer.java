package com.aulaspring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.aulaspring.entity.User;
import com.aulaspring.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;

	// sempre vai rodar no inicio da aplicaçao
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			createUser("Adilson", "adilsonoj@yahoo.co.b");
			createUser("Gon", "gon@yahoo.co.b");
			createUser("Killua", "killua@yahoo.co.b");
			
		}
		
		System.out.println(userRepository.findByName("Gon").getEmail());
		System.out.println(userRepository.buscaPorEmail("adils").getName());

	}
	
	public void createUser(String nome, String email) {
		User user = new User(nome, email);
		
		userRepository.save(user);
	}

}
