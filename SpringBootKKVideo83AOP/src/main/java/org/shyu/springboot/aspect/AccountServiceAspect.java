package org.shyu.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.shyu.springboot.model.Account;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountServiceAspect {

	@Before(value="execution *.AccountService.*(..) and args(account, ..) && @annotation(auditable)")
	public void beforeAdvice(JoinPoint joinPoint, Account account, Auditable auditable) {
		System.out.println("Account Service: " + joinPoint.getSignature());
		System.out.println("Account number: " + account.getAccountNumber() + ", Auditable Destination: " + auditable.value());
	}
}
