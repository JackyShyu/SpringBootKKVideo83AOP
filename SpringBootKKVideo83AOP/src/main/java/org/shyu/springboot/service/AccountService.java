package org.shyu.springboot.service;

import org.shyu.springboot.model.Account;

public interface AccountService {
	public abstract void updateAccountAmount(Account account, long amount);
	public abstract Account getAccountByCustomerId(String customerId) throws Exception;
}
