package com.qa.account.AccountProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.qa.account.repositories")
public class AccountProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountProjectApplication.class, args);
	}
}
