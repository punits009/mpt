package com.cg.service;
import java.sql.SQLException;

import com.cg.bean.*;
import com.cg.exception.InsufficientFundException;
public interface Transaction extends AccountOperation{
	public double withdraw(Account ob,double amount) throws InsufficientFundException, ClassNotFoundException, SQLException;
	public double deposit(Account ob,double amount) throws ClassNotFoundException, SQLException;
	public double[] transfer(Account from,Account to,double amount);
	public default void printStatement(Account ob)
	{
		System.out.println("=========================");
		System.out.println("Statement for Account No="+ob.getAid());
		System.out.println("Account Holder="+ob.getAccountholder());
		System.out.println("Balance is="+ob.getBalance());
		System.out.println("========================="); 
		
	}

}

