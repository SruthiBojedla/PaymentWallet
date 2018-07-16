package com.cg.wallet.dao;

import java.util.HashMap;
import com.cg.wallet.bean.Account;
import com.cg.wallet.db.WalletDB;
import com.cg.wallet.exception.WalletException;

/**
 * 
 * class name: WalletDao
 * interface: WAlletDaoImpl
 * No of methods:6
 *
 * @author bsruthi
 *Date of creation : 13-july-2018
 *last of modification : 14-july-2018
 */



public class WalletDao implements WalletDaoImpl{
	
	static HashMap<String, Account> walletMap = WalletDB.getwalletMap();

	@Override
	public Account CreateAccount(Account account) throws WalletException {
		if(walletMap.containsKey(account.getMobileNo())){
			throw new WalletException("Mobile number "+account.getMobileNo()+" already exists ");
		}
		walletMap.put(account.getMobileNo(),account);
		return account;
	}

	@Override
	public double ShowBalance(String mobileNo) throws WalletException {
		Account account=walletMap.get(mobileNo);
		if(!walletMap.containsKey(account.getMobileNo())){
			throw new WalletException("Mobile number "+account.getMobileNo()+" does not exist ");
		}
		return account.getBalance();
	}

	@Override
	public double Deposit(String mobileNo, double depo) throws WalletException {
		Account account=walletMap.get(mobileNo);
		if(!walletMap.containsKey(account.getMobileNo())){
			throw new WalletException("Mobile number "+account.getMobileNo()+" does not exist ");
		}
		account.setBalance(account.getBalance()+depo);
		return account.getBalance();
	}

	@Override
	public double Withdraw(String mobileNo, double amount)throws WalletException
	{
		Account account=walletMap.get(mobileNo);
		if(!walletMap.containsKey(account.getMobileNo()))
		{
			throw new WalletException("Mobile number "+account.getMobileNo()+" does not exist ");
		}
		else
		{
			if(amount<0)
			{
				throw new WalletException("withdraw not possible");
			}
		}
		account.setBalance(account.getBalance()-amount);
		return account.getBalance();
	}

	@Override
	public double FundTransfer(String mobile1, String mobile2, double transfer)throws WalletException 
	{
		Account account=walletMap.get(mobile1);
		Account account2=walletMap.get(mobile2);
		if(!walletMap.containsKey(account.getMobileNo())){
			throw new WalletException("Mobile number "+account.getMobileNo()+" does not exist ");
		}
		else if(!walletMap.containsKey(account2.getMobileNo())){
			throw new WalletException("Mobile number "+account2.getMobileNo()+" does not exist ");
		}		
		else if(transfer>account.getBalance() && transfer<0){
			throw new WalletException("transfer not possible because amount is not sufficient in "+account.getMobileNo());
		}
		account.setBalance(account.getBalance()-transfer);
		return account.getBalance();
	}

	@Override
	public Account PrintTransaction(Account account) throws WalletException {
		if(!walletMap.containsKey(account.getMobileNo()))
		{
			throw new WalletException("Mobile number "+account.getMobileNo()+" does not exist ");
		}
		return account;
	}

}
