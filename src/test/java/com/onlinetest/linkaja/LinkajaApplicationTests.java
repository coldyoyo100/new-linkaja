package com.onlinetest.linkaja;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinetest.linkaja.model.AccountModel;
import com.onlinetest.linkaja.repository.AccountRepo;

@SpringBootTest
class LinkajaApplicationTests {
	@Autowired
	AccountRepo accRepo;
	
	@Test
	void contextLoads() {
		AccountModel acc = new AccountModel(); 
		acc.setAccountNumber( 1L);
		acc.setCustomerNumber("1234");
		acc.setBalance(123456);
		
		accRepo.save(acc);
		
		assertTrue(false);
	}

}
