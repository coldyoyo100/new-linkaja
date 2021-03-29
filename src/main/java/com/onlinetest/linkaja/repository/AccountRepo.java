package com.onlinetest.linkaja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.onlinetest.linkaja.model.AccountModel;

@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<AccountModel, Long> {
	
	@Query(value = "Select acc.* From account acc WHERE acc.account_number = :accNo", nativeQuery = true)
	List<AccountModel> getInfoByAccNo(String accNo);
	
	@Query(value = "SELECT 1 FROM account acc WHERE acc.account_number = :accNo", nativeQuery = true)
	String checkAccount(String accNo);
}
