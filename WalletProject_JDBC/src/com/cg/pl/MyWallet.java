package com.cg.pl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import com.cg.bean.*;
import com.cg.exception.InsufficientFundException;
import com.cg.service.*;
public class MyWallet {
	public static void main(String args[]) throws IOException, InsufficientFundException, ClassNotFoundException, SQLException
	{
		AccountService service=new AccountService();
		Map<Long,Account>acc=new TreeMap<Long,Account>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String choice="";
		while(true)
		{
		System.out.println("Menu ");
		System.out.println("======");
		System.out.println("1 Create Account");
		System.out.println("2 Print all acccount");
		System.out.println("3 withdraw Account");
		System.out.println("4 delete Account");
		System.out.println("5 transfer money");
		System.out.println("6 deposit");
		System.out.println("7 find account");
		System.out.println("8 calculate gst");
		System.out.println("10 exit");
		System.out.println("======");
		System.out.println("Enter your choice");
		choice=br.readLine();
		
		switch(choice)
		{
		case "1":int id=0;
                 long mb=0L;
                 String ah="";
                 double bal=0.0;
        //Accepting and validtaiing I/p for account number
        System.out.println("Account Number");
        while(true)
        {
     	String s_id=br.readLine();
     	boolean ch1=Validator.validatedata(s_id, Validator.aidpattern);
     	if(ch1==true)
     	{
     		try
     		{
     			id=Integer.parseInt(s_id);
     			break;
     		}
     		catch(NumberFormatException e)
     		{
     			System.out.println("Account Number must be Numeric. ReEnter");
     		}
     	}
     	else
     	{
     		System.out.println("ReEnter Account Number in 3 digits");
     	}
        }//end of account number while
        
        System.out.println("Mobile Number");
        while(true)
        {
     	String s_mb=br.readLine();
     	boolean ch1=Validator.validatedata(s_mb, Validator.mobpattern);
     	if(ch1==true)
     	{
     		try
     		{
     			mb=Long.parseLong(s_mb);
     			break;
     		}
     		catch(NumberFormatException e)
     		{
     			System.out.println("Mobile Number must be Numeric. ReEnter");
     		}
     	}
     	else
     	{
     		System.out.println("ReEnter Mobile Number in 10 digits");
     	}
        }//end of mobile number while
        
        System.out.println("Account holder name");
        while(true)
        {
     	String s_ah=br.readLine();
     	boolean ch1=Validator.validatedata(s_ah, Validator.accpattern);
     	if(ch1==true)
     	{
     		try
     		{
     			ah=s_ah;;
     			break;
     		}
     		catch(NumberFormatException e)
     		{
     			System.out.println("name must be string. ReEnter");
     		}
     	}
     	else
     	{
     		System.out.println("ReEnter name in");
     	}
        }//end of account holder while
        
        System.out.println("Balance");
        while(true)
        {
        	String s_ba=br.readLine();
        boolean ch1=Validator.validatedata(s_ba, Validator.balpattern);
        if(ch1==true)
        {
        	try {
        		bal=Double.parseDouble(s_ba);
        	}
        	catch(NumberFormatException e)
        	{
        		System.out.println("Enter in numeric");
        	}
        }
        else
        {
        	System.out.println("Enter in numeric ");
        }
        
        if(bal>0)
        {
        Account ob=new Account(id,mb,ah,bal);
        acc.put((long)ob.getAid(), ob);
        break;
        }
        else
        {
     	   System.out.println("Balance can't ne less than zero ");
     	   System.out.println("ReEnter the balance");
        }
        }//end of balance while
	       break;
	       
	       
        case "2":Collection<Account> vc=acc.values();
                 List<Account> acclist=new ArrayList<Account>(vc);
        
                 for(Account o:acclist)
                 {
     	           service.printStatement(o);
                 }
	              break;
	              
	              
        case "3":System.out.println("enter account number");
        	     long accid=Long.parseLong(br.readLine());
        	     System.out.println("enter amount");
        	     double am=Double.parseDouble(br.readLine());
        	     service.printStatement(acc.get(accid));
        	      service.withdraw(acc.get(accid), am);
        	      break;
        	      
        	      
        case "4":System.out.println("enter account number");
                  long acccid=Long.parseLong(br.readLine());
                  acc.remove(acccid);
                  //service.deleteAccount(acc.get(acccid));
                  break;
                  
                  
        case "5":System.out.println("enter from account number");
                  long acid=Long.parseLong(br.readLine());
                  System.out.println("enter to account number");
                  long tcid=Long.parseLong(br.readLine());
                  System.out.println("enter amount");
                  double amt=Double.parseDouble(br.readLine());
                  service.transfer(acc.get(acid),acc.get(tcid), amt);
                  break;
                  
                  
        case "6":System.out.println("Etter the Account number");
                      long did=Long.parseLong(br.readLine());
                      System.out.println("enter amount");
                      double amo=Double.parseDouble(br.readLine());
                      service.deposit(acc.get(did), amo);
                      break;
                      
        case "7":System.out.println("Enter the Account number");
                       did=Long.parseLong(br.readLine());  
                       System.out.println(acc.get(did));
                       break;
                       
        case "8":System.out.println("Enter the Account number");
                      did=Long.parseLong(br.readLine()); 
                      service.calculateTax(Gst.PCT_5, acc.get(did).getBalance());
                      
        case "10":System.out.println("exiting Program");
	             System.exit(0);
	              break;
        default: System.out.println("Invalid choice");
        }
		
		}
		//for(long a:acc.keySet())
		//{
		//service.printStatement(acc.get(a));
		//}
		/*double b1=0.0;
		try {
		b1=service.withdraw(,55000);
		System.out.println("After withdraw balance is="+b1);
		}
		catch(InsufficientFundException e)
		{
			System.err.println(e.getMessage());
			System.err.println(e);
		}
		double tax=service.calculateTax(Gst.PCT_5,b1);
		System.out.println("gst is="+tax);*/
	}
	
}


