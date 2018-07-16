package com.cg.wallet.dao;

import com.cg.wallet.bean.Account;
import com.cg.wallet.exception.WalletException;

public interface WalletDaoImpl {

	Account CreateAccount(Account account)throws WalletException;
	double ShowBalance(String mobileNo)throws WalletException;
	double Deposit(String mobileNo,double depo)throws WalletException;
	double Withdraw(String mobileNo,double amount)throws WalletException;
	double FundTransfer(String mobile1,String mobile2,double transfer)throws WalletException;
	Account PrintTransaction(Account account)throws WalletException;
}
