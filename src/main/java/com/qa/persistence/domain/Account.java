package com.qa.persistence.domain;

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
	@Pattern(regexp="[^A-Za-z]+",message="Last name must contain only alphabetic letters")
	private String firstName;
	
	@Column(name="last_name", length=30)
	@NotNull
	@Pattern(regexp="[^A-Za-z]+",message="Last name must contain only alphabetic letters")
	private String lastName;
	
	@Column(name="account_no", length=6)
	@Size(min=6,max=6,message="Account number must be a length of exactly {max}")
	@NotNull
	@Pattern(regexp="[^0-9]+",message="Account number can only contain numerical values")
	private String accountNumber;
	
	public Account() {}
	
	public Account(@NotNull String firstName, @NotNull String lastName, @NotNull String accountNumber) {
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
