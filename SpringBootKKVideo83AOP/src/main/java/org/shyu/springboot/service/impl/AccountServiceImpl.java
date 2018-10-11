package org.shyu.springboot.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.shyu.springboot.aspect.Auditable;
import org.shyu.springboot.aspect.Auditable.AuditDestination;
import org.shyu.springboot.model.Account;
import org.shyu.springboot.service.AccountService;
import org.springframework.stereotype.Service;

@Service("AccountService")
public class AccountServiceImpl{
	
	private static Map<String, Account> accountMap = new HashMap<>();
	
	static {
		accountMap.put("c123", new Account("123", "JackyAccount"));
		accountMap.put("c456", new Account("456", "LeeAccount"));
	}

	@Auditable(AuditDestination.FILE_SYSTEM)
	//@Override
	public void updateAccountAmount(Account account, long amount) {
		System.out.println("Account amount updated: account number:" + account.getAccountNumber() + " -- with amount: " + amount);
	}
	
	//@Auditable(AuditDestination.DATABASE)
	//@Override
	public Account getAccountByCustomerId(String customerId) throws Exception {
		if (customerId == null) {
			throw new Exception("Customer Id cannot be null");
		}
		
		Set<Entry<String, Account>> accountSet = accountMap.entrySet();
		for (Entry<String, Account> entry: accountSet) {
			if (entry.getKey().toString().equalsIgnoreCase(customerId)) {
				System.out.println("getAccountByCustomerId: " + customerId + ", Account description: " + entry.getValue().getAccountDescription());
				return entry.getValue();
			}
		}
		
		return null;
	}

}
