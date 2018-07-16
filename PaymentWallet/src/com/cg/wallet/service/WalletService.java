package com.cg.wallet.service;

import com.cg.wallet.bean.Account;
import com.cg.wallet.dao.WalletDao;
import com.cg.wallet.dao.WalletDaoImpl;
import com.cg.wallet.exception.WalletException;

/**
 * 
 * class name: WalletService
 * interface: WalletServiceImpl
 * No of methods:10
 *
 * @author bsruthi
 *Date of creation : 13-july-2018
 *last of modification : 14-july-2018
 */
public class WalletService implements WalletServiceImpl{

	WalletDaoImpl walletdao=new WalletDao();

	@Override
	public Account CreateAccount(Account account) throws WalletException {
		return walletdao.CreateAccount(account);
	}

	@Override
	public double ShowBalance(String mobileNo) throws WalletException {
		return walletdao.ShowBalance(mobileNo);
	}

	@Override
	public double Deposit(String mobileNo, double depo) throws WalletException {
		return walletdao.Deposit(mobileNo, depo);
	}

	@Override
	public double Withdraw(String mobileNo, double amount)throws WalletException {
		return walletdao.Withdraw(mobileNo, amount);
	}

	@Override
	public double FundTransfer(String mobile1, String mobile2, double transfer)
			throws WalletException {
		return walletdao.FundTransfer(mobile1, mobile2, transfer);
	}
	
	public boolean ValidateCustomerName(String name)throws WalletException{
		if(name.isEmpty()||name==null){
			throw new WalletException("Employee name cannot be empty");
		}
		else{
			if(!name.matches("[A-Z][A-Za-z]{3,}")){
				throw new WalletException("Name should start with capital and should have only alphabets");
			}
		}
		return true;
		
	}
	
	public boolean ValidatemobileNo(String mobileNo)throws WalletException{
		if(!mobileNo.matches("\\d{10}")){
			throw new WalletException("Mobile number should contain 10 numbers");
		}
		return true;
	}
	
	public boolean ValidateemailId(String emailId)throws WalletException{
		if(!emailId.matches("[a-z0-9]{8,}[@][a-z]{5}\\.{1}[com]")){
			throw new WalletException("Invalid email id");
		}
		return true;
	}
	
	public boolean validateAccount(Account account)throws WalletException{
		if(ValidateCustomerName(account.getName()) && ValidatemobileNo(account.getMobileNo()) 
				&& ValidateemailId(account.getEmailId())){
		return true;
		}
		else{
			throw new WalletException("Invalid Data");
		}
		
	}

	@Override
	public Account PrintTransaction(Account account) throws WalletException {
		return walletdao.PrintTransaction(account);
	}
}
