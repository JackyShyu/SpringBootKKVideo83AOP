package org.shyu.springboot;

import org.shyu.springboot.model.Account;
import org.shyu.springboot.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringBootKkVideo83AopApplication implements CommandLineRunner{
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKkVideo83AopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account("123", "ShyuAccount");
		//accountServiceImpl.updateAccountAmount(account, 3000);
		accountServiceImpl.getAccountByCustomerId("c456");	
		
		/*//Collection -> Array
		List<Account> accountsA = new ArrayList<>();
		Object[] object = accountsA.toArray();
		
		//Array -> Collection
		List<Object> objects = Arrays.asList(object);
		List<Object> objects1 = new ArrayList<Object>(Arrays.asList(object));*/
	}
}
