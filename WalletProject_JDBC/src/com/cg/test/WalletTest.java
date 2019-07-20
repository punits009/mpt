package com.cg.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import com.cg.service.*;
import com.cg.dao.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cg.service.*;
import com.sun.javafx.collections.MappingChange.Map;

import com.cg.bean.Account;
import com.cg.dao.*;
import com.cg.exception.InsufficientFundException;

class WalletTest {
	private AccountService service;
	private AccountDAO mockDao;
	Scanner input = new Scanner(System.in);
	

	@Test
	void testwithdraw() throws InsufficientFundException, ClassNotFoundException, SQLException {
		Account a=new Account();
		a.setBalance(50000);
		
		AccountService ob=new AccountService();
		
		assertEquals(45000.00,ob.withdraw(a, 5000.00));
	    assertThrows(InsufficientFundException.class,()->ob.withdraw(a,44500.00));
		
	}
	@Test
	void testdeposit() throws InsufficientFundException, ClassNotFoundException, SQLException {
		Account a=new Account();
		a.setBalance(50000);
		AccountService ob=new AccountService();
	    assertEquals(55000,ob.deposit(a, 5000));
		
	}
	@Test
	void testtransferMoney() throws InsufficientFundException{
		AccountService ob=new AccountService();
		Account a=new Account();
		a.setBalance(50000);
		Account b=new Account();
		b.setBalance(20000);
		double c[]=ob.transfer(a, b, 7000);
		assertEquals(c[0],43000);
		assertEquals(c[1],27000);
	
	}
	@Test
	void testaddaccount() throws InsufficientFundException, ClassNotFoundException, SQLException {
		Account a=new Account(101,1234567890,"Ram",45000.00);
		AccountService ob=new AccountService();
		HashMap<Long,Account> acc=new HashMap<Long,Account>();
		acc.put((long)a.getAid(),a);
		
		assertEquals( acc.get(a.getAid()),ob.addAccount(a));
		
		
	}
	
	@Test
	void testFindaccountBymoblie() throws ClassNotFoundException, SQLException 
	{
		Account a=new Account();
		long m=1234567890L;
		a.setMobile(m);
        service=new AccountService();
		mockDao = EasyMock.createMock(AccountDAO.class);
		service.setDao(mockDao);
		
		
		EasyMock.expect(mockDao.findAccount(m)).andReturn(a);
		EasyMock.replay(mockDao);
		Assertions.assertTrue(service.findAccount(m)!=null);
		EasyMock.verify(mockDao);

		
	}
	
	
	
	

}
