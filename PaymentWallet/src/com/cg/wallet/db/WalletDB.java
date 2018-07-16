package com.cg.wallet.db;

import java.util.HashMap;
import com.cg.wallet.bean.Account;

public class WalletDB {

	private static HashMap<String, Account>walletDb = new HashMap<String, Account>();

	public static HashMap<String, Account> getwalletMap()
	{
			return walletDb;
	
	}
	
	static
	{
		walletDb.put("9666220196", new Account("9666220196","Sruthi","sruthi@capgemini.com",10000));
		walletDb.put("9666666666", new Account("9666666666","Narmatha","narmatha@capgemini.com",20000));
		walletDb.put("9888888888", new Account("9888888888","Akanksha","akanksha@capgemini.com",30000));
		walletDb.put("9000000000", new Account("9000000000","Teju","teju@capgemini.com",40000));
		walletDb.put("9222222222", new Account("9222222222","Vaishu","vaishu@capgemini.com",50000));
		walletDb.put("9444444444", new Account("9444444444","Bhavya","bhavya@capgemini.com",60000));
	}	
}
