package org.shyu.springboot;

import org.shyu.springboot.model.Account;
import org.shyu.springboot.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKkVideo83AopApplication implements CommandLineRunner{
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKkVideo83AopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account("123", "ShyuAccount");
		accountServiceImpl.updateAccountAmount(account, 3000);	
	}
}
