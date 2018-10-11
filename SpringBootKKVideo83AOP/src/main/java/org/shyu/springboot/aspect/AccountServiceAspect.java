package org.shyu.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.shyu.springboot.model.Account;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountServiceAspect {

	//@Before(value="execution *.AccountService.*(..) and args(account, ..) && @annotation(auditable)")
	//@Before(value="args(account, amount) && @annotation(auditable)")
	@Before(value="allWithAccountAmount(account, amount, auditable)")
	public void beforeAdvice(JoinPoint joinPoint, Account account, Auditable auditable, long amount) {
		System.out.println("Account Service: " + joinPoint.getSignature());
		System.out.println("Account number: " + account.getAccountNumber() + ", Auditable Destination: " + auditable.value() + ", amount: " + amount);
	}
	
	//@AfterReturning(value="args(customerId)", returning="account")
	//@AfterReturning(value="execution *.getAccountByCustomerId(String customerId)")
	//@AfterReturning(value="args(customerId)", returning="account")
	//@AfterReturning(value = "within(org.shyu.springboot.service.impl.AccountServiceImpl)", returning="account")
	//@AfterReturning(value="withCustomerId(customerId)", returning="account")
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
	
	@Pointcut("args(account, amount) && @annotation(auditable)")
	public void allWithAccountAmount(Account account, long amount, Auditable auditable) {};
	
	@Pointcut("args(customerId)")
	public void withCustomerId(String customerId) {};
	
	@Around("allWithAccountAmount(account, amount, auditable)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint, Account account, Auditable auditable, long amount) {
		System.out.println("Before proceed: " + joinPoint.getSignature());
		try {
			joinPoint.proceed();
			System.out.println("Account: " + account);
		} catch (Throwable e) {
			System.out.println("Get Exception: " + e.getMessage());
		}
		System.out.println("After proceed: " + joinPoint.getSignature() + "/n" + "********");
		return null;
	}
}
