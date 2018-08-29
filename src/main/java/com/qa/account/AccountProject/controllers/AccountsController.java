package com.qa.account.AccountProject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.AccountProject.models.Account;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {
	
	@GetMapping
	public List<Account> getAllAccounts()
	{
		List<Account> accounts = new ArrayList<>();
		return accounts;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createAccount(@RequestBody Account account)
	{
		
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") long id)
	{
		return new Account();
	}
}
