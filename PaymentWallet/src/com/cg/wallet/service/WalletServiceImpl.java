package com.cg.wallet.service;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;

public interface WalletServiceImpl {

	Account CreateAccount(Account account)throws WalletException;
	double ShowBalance(String mobileNo)throws WalletException;
	double Deposit(String mobileNo,double depo)throws WalletException;
	double Withdraw(String mobileNo,double amount)throws WalletException;
	double FundTransfer(String mobile1,String mobile2,double transfer)throws WalletException;
	public boolean validateAccount(Account account)throws WalletException;
	public boolean ValidateCustomerName(String name)throws WalletException;
	public boolean ValidatemobileNo(String mobileNo)throws WalletException;
	public boolean ValidateemailId(String emailId)throws WalletException;
	Account PrintTransaction(Account account)throws WalletException;

}
