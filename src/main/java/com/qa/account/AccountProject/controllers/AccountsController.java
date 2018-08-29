package com.qa.account.AccountProject.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qa.account.AccountProject.models.Account;
import com.qa.util.JSONUtil;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@GetMapping
	public String getAllAccounts()
	{
		TypedQuery<Account> query = em.createQuery("Select a FROM Account a ORDER m.id DESC",Account.class);
		List<Account> accounts = (List<Account>) query.getResultList();
		return util.convertObjectToJSON(accounts);
	}
	
	@PostMapping
	@Transactional(TxType.REQUIRED)
	public String createAccount(String account)
	{
		Account acc = util.convertJSONToObject(account, Account.class);
		em.persist(acc);
		return "Account has been added";
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable("id") long id)
	{
		return new Account();
	}
}
