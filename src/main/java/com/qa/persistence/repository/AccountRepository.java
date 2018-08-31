package com.qa.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.persistence.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
