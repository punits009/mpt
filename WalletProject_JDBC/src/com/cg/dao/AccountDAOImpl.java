package com.cg.dao;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.bean.Account;

public class AccountDAOImpl implements AccountDAO{
	
    Map<Long,Account> acc=new HashMap<Long,Account>();
    public Connection jdbcsetup() throws SQLException, ClassNotFoundException
    {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	//Now establish the connection
    	String url="jdbc:oracle:thin:@localhost:1521:xe";
    	String user="hr";
    	String pass="hr";
    	Connection con=DriverManager.getConnection(url,user,pass);
    	System.out.println("Successfully connected");
    	System.out.println();
    	return con; 	
    }
    
	@Override
	public Account addAccount(Account ob) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		acc.put(ob.getMobile(), ob);
		Connection con=jdbcsetup();
		int id=ob.getAid();
		long mobile=ob.getMobile();
		String ah=ob.getAccountholder();
		double bal=ob.getBalance();
		String query="insert into account values(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, id);
		st.setLong(2, mobile);
		st.setString(3, ah);
		st.setDouble(4, bal);
		int res=st.executeUpdate();
		System.out.println(res+" records created");
		con.commit();
		con.close();
		acc.put(ob.getMobile(), ob);
		return ob;	}

	@Override
	public boolean updateAccount(Account ob) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteAccount(Account ob) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		acc.remove(ob.getAid());
		Connection con=jdbcsetup();
		int aid=ob.getAid();
		String query="delete from account where aid=?";
		PreparedStatement st=con.prepareStatement(query);
		st.setInt(1, aid);
		int res=st.executeUpdate();
		System.out.println(res+" records deleted");
		return true;
	}

	@Override
	public Account findAccount(Long mobileno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Account ob=acc.get(mobileno);
		Connection con=jdbcsetup();
		int aid=ob.getAid();
		String q="select * from account where aid=?";
		PreparedStatement st=con.prepareStatement(q);
		st.setInt(1, aid);
		ResultSet rs=st.executeQuery();
		Account a=new Account();
		while(rs.next())
		{
			a.setAid(rs.getInt(1));
			a.setMobile(2);
			a.setAccountholder(rs.getString(3));
			a.setBalance(rs.getDouble(4));
			
		}
		System.out.println(a); 
		
		return a;
	}

	@Override
	public Map<Long, Account> getallAccount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con=jdbcsetup();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from account");
		while(rs.next())
		{
			int aid=rs.getInt(1);
			long mob=rs.getLong(2);
			String ah=rs.getString(3);
			Double bal=rs.getDouble(4);
			System.out.println("Accountid= "+aid+" mobile ="+mob+" Account holder= "+ah+" balance= "+bal);
			System.out.println();
			System.out.println("==========================================================================");
			System.out.println();
		}
		return acc;
	}
	

}
