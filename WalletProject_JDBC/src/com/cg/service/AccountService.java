package com.cg.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.cg.bean.*;
import com.cg.dao.AccountDAO;
import com.cg.dao.AccountDAOImpl;
import com.cg.exception.InsufficientFundException;


public class AccountService implements Transaction,Gst{
	AccountDAO dao=new AccountDAOImpl();
	;
	public AccountService() {
		// TODO Auto-generated constructor stub
		dao=new AccountDAOImpl();
	}
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

	@Override
	public double calculateTax(double PCT, double amount) {
		// TODO Auto-generated method stub
		
		
		return amount*Gst.PCT_5;
	}

	@Override
	public double withdraw(Account ob, double amount) throws InsufficientFundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		double new_Balance=ob.getBalance()-amount;
		if(new_Balance<1000)
		{
			new_Balance=ob.getBalance();
			//System.out.println("Insufficient BAlance");
			//throw new RuntimeException("Insufficient Funds Can not process withdrawl");
			throw new InsufficientFundException("Insufficient Funds Can not process withdrawl",new_Balance);
		}
		ob.setBalance(new_Balance);
		double b=ob.getBalance();
		int aid=ob.getAid();
		AccountDAOImpl i=new AccountDAOImpl();
		Connection con=i.jdbcsetup();
		String q="update account set balance=bal where aid=aid";
		PreparedStatement st=con.prepareStatement(q);
		st.setInt(1, aid);
		int r=st.executeUpdate();
		return new_Balance;
	}

	@Override
	public double deposit(Account ob, double amount) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		if(amount>0)
		{
		double new_Balance=ob.getBalance()+amount;
		ob.setBalance(new_Balance);
		double b=ob.getBalance();
		int aid=ob.getAid();
		AccountDAOImpl i=new AccountDAOImpl();
		Connection con=i.jdbcsetup();
		String q="update account set balance=bal where aid=aid";
		PreparedStatement st=con.prepareStatement(q);
		st.setInt(1, aid);
		int r=st.executeUpdate();
		return new_Balance;
		
		}
		else
		{
			System.out.println("ENter balance greater than 0");
			return ob.getBalance();
		}
		
		
	}

	@Override
	public double[] transfer(Account from, Account to, double amount) {
		// TODO Auto-generated method stub
		double a[]=new double[2];
		double new_Balance=from.getBalance()-amount;
		if(new_Balance<1000)
		{
			System.out.println("Insufficient Balance");
			//return "Amounnt can not be transfered";
			a[0]=from.getBalance();
			a[1]=to.getBalance();
			return a;
		}
		else
		{
		from.setBalance(new_Balance);
		double b2=to.getBalance()+amount;
		to.setBalance(b2);
		
		a[0]=from.getBalance();
		a[1]=to.getBalance();
		String ans="from acccount= "+from.getAid()+" to account= "+to.getAid()+" balance= "+from.getBalance()+" to ="+to.getBalance();
		return a;
	}}

	@Override
	public Account addAccount(Account ob) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//dao.addAccount(ob);
		return dao.addAccount(ob);
	}

	@Override
	public boolean deleteAccount(Account ob) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dao.deleteAccount(ob);
		return true;
	}

	@Override
	public Account findAccount(Long mobileno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.findAccount(mobileno);
	}

	@Override
	public Map<Long, Account> getallAccount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return dao.getallAccount();
	}
	

}
