package org.shyu.springboot.service.impl;

import org.shyu.springboot.model.Account;
import org.shyu.springboot.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public void updateAccountAmount(Account account, long amount) {
		System.out.println("Account amount updated: account number:" + account.getAccountNumber() + " -- with amount: " + amount);
	}

}
