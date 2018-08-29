package com.qa.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.account.AccountProject.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
