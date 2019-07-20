package com.cg.service;

import java.sql.SQLException;
import java.util.Map;

import com.cg.bean.Account;

public interface AccountOperation {
	public Account addAccount(Account ob) throws ClassNotFoundException, SQLException;
	public boolean deleteAccount(Account ob) throws ClassNotFoundException, SQLException;
	public Account findAccount(Long mobileno) throws ClassNotFoundException, SQLException;
	public Map<Long,Account> getallAccount() throws ClassNotFoundException, SQLException;


}
