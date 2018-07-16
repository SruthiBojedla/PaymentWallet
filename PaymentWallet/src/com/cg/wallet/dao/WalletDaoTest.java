package com.cg.wallet.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.cg.wallet.bean.Account;
import com.cg.wallet.db.WalletDB;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.service.WalletService;
import com.cg.wallet.service.WalletServiceImpl;

public class WalletDaoTest {

	@Before
	public void testException() throws WalletException{
		
	}
	
	@After
	public void testException1() throws WalletException{
		
	}
	
	Account account = new Account();
	HashMap<String, Account> walletMap = WalletDB.getwalletMap();
	WalletServiceImpl services = new WalletService();
	
	@Test
	public void testInvalidMobileNo(){
		try {
			assertFalse(services.ValidatemobileNo("2345"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidNullMobileNo(){
		try {
			assertFalse(services.ValidatemobileNo(""));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testvalidMobileNo(){
		try {
			assertTrue(services.ValidatemobileNo("9876543210"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidCustName(){
		try {
			assertFalse(services.ValidateCustomerName("xyz"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidCustomerName(){
		try {
			assertFalse(services.ValidateCustomerName("xyz123"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidNullCustName(){
		try {
			assertFalse(services.ValidateCustomerName(""));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testvalidCustName(){
		try {
			assertTrue(services.ValidateCustomerName("Sruthi"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidEmail(){
		try {
			assertFalse(services.ValidateemailId("vsydkf"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testvalidEmailId(){
		try {
			assertTrue(services.ValidateemailId("sruthi@gmail.com"));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidAccount(){
		account.setMobileNo("2345");
		account.setName("xyz");
		account.setEmailId("dkfuish");
		account.setBalance(0);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	@Test
	public void testValidAccount(){
		account.setMobileNo("9876543210");
		account.setName("Sruthi");
		account.setEmailId("sruthi@gmail.com");
		account.setBalance(600.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testAccountInvalidMobile(){
		account.setMobileNo("9876");
		account.setName("Sruthi");
		account.setEmailId("sruthi@gmail.com");
		account.setBalance(600.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testAccountInvalidName(){
		account.setMobileNo("9876543210");
		account.setName("sruthi");
		account.setEmailId("sruthi@gmail.com");
		account.setBalance(600.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testAccountNullName(){
		account.setMobileNo("9876543210");
		account.setName("");
		account.setEmailId("sruthi@gmail.com");
		account.setBalance(600.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testAccountInvalidCustName(){
		account.setMobileNo("9876543210");
		account.setName("Sruthi123");
		account.setEmailId("sruthi@gmail.com");
		account.setBalance(600.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testAccountInvalidEmail(){
		account.setMobileNo("9876");
		account.setName("Sruthi");
		account.setEmailId("sruthi");
		account.setBalance(600.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testAccountInvalidBalance(){
		account.setMobileNo("9876");
		account.setName("Sruthi");
		account.setEmailId("sruthi@gmail.com");
		account.setBalance(-0.00);
		try {
			assertFalse(services.validateAccount(account));
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testValidShowBalance(){
		account.setMobileNo("9666666666");
		try {
			services.ShowBalance("9666666666");
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInValidShowBalance(){
		account.setMobileNo("96");
		try {
			services.ShowBalance("9666666666");
		} catch (WalletException e) {
			assertEquals("number does not exist",e.getMessage());
		}
	}
	
	@Test
	public void testValidDeposit(){
		account.setMobileNo("9666220196");
		try {
			services.Deposit("9666220196", 500);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInvalidDepositamount(){
		account.setMobileNo("9666220196");
		try {
			services.Deposit("9666220196",-567);
		} catch (WalletException e) {
			assertEquals("deposit amount cannot be negative",e.getMessage());
		}
	}
	
	@Test
	public void testValidWithdraw(){
		account.setMobileNo("9666220196");
		try {
			services.Withdraw("9666220196", 400);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInValidWithdrawAmount(){
		account.setMobileNo("9666220196");
		try {
			services.Withdraw("9666220196",-400);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testValidFundTransfer(){
		Account account1 = new Account();
		account.setMobileNo("9666666666");
		account1.setMobileNo("9666220196");
		try {
			services.FundTransfer("9666666666", "9666220196", 500);
		} catch (WalletException e) {
			System.out.println();
			System.out.println(e.getMessage());
			System.out.println();
		}
	}
	
	@Test
	public void testInValidFundTransfer(){
		Account account1 = new Account();
		account.setMobileNo("9666666666");
		account1.setMobileNo("9666220196");
		try {
			services.FundTransfer("9666666666", "9666220196", -500);
		} catch (WalletException e) {
			assertEquals("transfer amount should be gretaer than zero and less than available amount",e.getMessage());
		}
	}	
}
