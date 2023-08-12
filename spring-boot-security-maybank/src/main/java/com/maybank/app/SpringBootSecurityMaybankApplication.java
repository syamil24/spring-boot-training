package com.maybank.app;

import com.maybank.app.dto.Users;
import com.maybank.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityMaybankApplication {

	@Autowired
	static UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityMaybankApplication.class, args);
	}

	public void run(String... args) throws Exception {
		Users u1 = new Users();
		u1.setName("test");
		u1.setPassword("test");
		u1.setRole("ROLE_ADMIN");

		Users u2 = new Users();
		u2.setName("test2");
		u2.setPassword("test2");
		u2.setRole("ROLE_USER");

		repository.save(u1);
		repository.save(u2);
	}

}
