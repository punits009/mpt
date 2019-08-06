package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	/**The application runs at port number 8085. 
	 * Please go to http://localhost:8085/accounts with GET request to see the output, it will show all the initial accounts
	 * To create a new account add /new to the above URL
	 * To update account use /id with PUT request
	 * To delete account use /id with DELETE request
	 * To find a account use /id with GET request
	 */
	
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	
	 }
}
