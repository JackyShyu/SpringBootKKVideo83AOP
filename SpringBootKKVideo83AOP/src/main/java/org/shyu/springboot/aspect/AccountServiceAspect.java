package org.shyu.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.shyu.springboot.model.Account;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountServiceAspect {

	//@Before(value="execution *.AccountService.*(..) and args(account, ..) && @annotation(auditable)")
	//@Before(value="args(account, amount) && @annotation(auditable)")
	public void beforeAdvice(JoinPoint joinPoint, Account account, Auditable auditable, long amount) {
		System.out.println("Account Service: " + joinPoint.getSignature());
		System.out.println("Account number: " + account.getAccountNumber() + ", Auditable Destination: " + auditable.value() + ", amount: " + amount);
	}
	
	//@AfterReturning(value="args(customerId)", returning="account")
	//@AfterReturning(value="execution *.getAccountByCustomerId(String customerId)")
	//@AfterReturning(value="args(customerId)", returning="account")
	@AfterReturning(pointcut = "within(org.shyu.springboot.service.impl.**)", returning="account")
	public void afterReturningAdvice(JoinPoint joinPoint, String customerId, Account account) {
		System.out.println("Account Service: " + joinPoint.getSignature());
		//System.out.println("Account number: " + account.getAccountNumber());
		System.out.println("Customer Id: " + customerId);
	}
	
	//@AfterThrowing(value="args(account, ..)", throwing="ex")
	//@AfterThrowing(value="args(account, ..) && @annotation(auditable)")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex, Auditable auditable) {
		System.out.println("Account Service: " + joinPoint.getSignature());
		System.out.println("Exception: " + ex.getMessage());
	}
}
