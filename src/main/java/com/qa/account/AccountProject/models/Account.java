package com.qa.account.AccountProject.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_accounts")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name", length=30)
	@NotNull
	private String firstName;
	
	@Column(name="last_name", length=30)
	@NotNull
	private String lastName;
	
	@Column(name="account_no", length=6)
	@NotNull
	private String accountNumber;
	
	public Account() {}
	
	public Account(long id, @NotNull String firstName, @NotNull String lastName, @NotNull String accountNumber) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
