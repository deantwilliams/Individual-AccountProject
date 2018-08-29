package com.qa.account.AccountProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.AccountProject.models.Account;
import com.qa.account.repositories.AccountRepository;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@GetMapping
	public List<Account> getAllAccounts()
	{
		return accountRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createAccount(@RequestBody Account account)
	{
		accountRepo.save(account);
	}
	
	@PostMapping("/{id}")
	@ResponseStatus(HttpStatus.GONE)
	public void deleteAccount(@PathVariable("id") long id)
	{
		accountRepo.deleteById(id);
	}
	
	@PostMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public void updateAccount(@RequestBody Account accountUpdated)
	{
		Account accountToUpdate = getSingleAccount(accountUpdated.getId());
		if(accountToUpdate != null)
		{
			accountUpdated.setId(accountToUpdate.getId());
			accountRepo.save(accountUpdated);
		}
		
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") long id)
	{
		return getSingleAccount(id);
	}
	
	private Account getSingleAccount(long id)
	{
		return accountRepo.getOne(id);
	}
}
