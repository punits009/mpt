package com.cg.dao;
import java.sql.SQLException;
import java.util.Map;

import com.cg.bean.*;

public interface AccountDAO {
	public Account addAccount(Account ob) throws ClassNotFoundException, SQLException;
	public boolean updateAccount(Account ob);
	public boolean deleteAccount(Account ob) throws ClassNotFoundException, SQLException;
	public Account findAccount(Long mobileno) throws ClassNotFoundException, SQLException;
	public Map<Long,Account> getallAccount() throws ClassNotFoundException, SQLException;

}
