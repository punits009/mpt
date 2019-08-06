package com.cg.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Service.AccountService;
import com.cg.entities.Account;
import com.cg.inputFormats.DepositAndWithdraw;
import com.cg.inputFormats.TranserFundFormat;

@CrossOrigin()
@RestController
@RequestMapping("/accounts")

public class AccountController {

	@Autowired
	AccountService service;

	Account a1 = new Account(101, "9999999999", "Vinay", 50000.0);
	Account a2 = new Account(102, "9999999998", "Ashu", 500000.0);
	Account a3 = new Account(103, "9999999997", "Yashu", 200000.0);

	// @PostConstruct
	// public void populate() {
	// service.addAccount(a1);
	// service.addAccount(a2);
	// service.addAccount(a3);
	// }

	@GetMapping(value = "/")
	public List<Account> getAll() {
		// to view all the available accounts

		return service.getAllAccounts();
	}

	@GetMapping(value = "/find/{id}")
	public Account findById(@PathVariable int id) {
		// to find a account by id

		return service.findAccount(id);
	}

	@PostMapping(value = "/new", consumes = { "application/json" })
	public Account addAccount(@RequestBody Account account) {
		// to save a new product
		System.out.println("in java");
		System.out.println(account);
		service.addAccount(account);
		return account;
	}

	@PutMapping(value = "/update/{id}", consumes = { "application/json" })
	public Account update(@RequestBody Account account, @PathVariable int id) {
		// to update an existing product

		// Product p = service.find(id);
		service.update(id, account);
		
		return service.findAccount(account.getId());
	}

	@DeleteMapping(value = "/delete/{id}")
	public Account delete(@PathVariable int id) {
		// to delete an existing product

		Account a = service.findAccount(id);
		Account b=a;
		service.deleteAccount(a);
		System.out.println(b);
		return b;
	}

	@PutMapping(value = "/withdraw", consumes = { "application/json" })
	public double withdraw(@RequestBody DepositAndWithdraw input) {
		Account a = service.findAccount(input.getId());
		double amount = input.getAmount();

		return service.withdraw(a, amount);
	}

	@PutMapping(value = "/deposit", consumes = { "application/json" })
	public double deposit(@RequestBody DepositAndWithdraw input) {
		Account a = service.findAccount(input.getId());
		double amount = input.getAmount();

		return service.deposit(a, amount);
	}

	@PutMapping(value = "/transfer", consumes = { "application/json" })
	public double[] transferMoney(@RequestBody TranserFundFormat input) {
 
		int id1 = input.getId1();
		int id2 = input.getId2();
		double amount = input.getAmount();

		Account from = service.findAccount(id1);
		Account to = service.findAccount(id2);

		return service.transferMoney(from, to, amount);
	}

}
