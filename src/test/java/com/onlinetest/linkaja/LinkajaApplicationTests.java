package com.onlinetest.linkaja;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.util.Arrays;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinetest.linkaja.dto.AccountDto;
import com.onlinetest.linkaja.dto.CustomerDto;
import com.onlinetest.linkaja.model.AccountModel;
import com.onlinetest.linkaja.model.CustomerModel;
import com.onlinetest.linkaja.repository.AccountRepo;
import com.onlinetest.linkaja.repository.CustomerRepo;

@SpringBootTest
class LinkajaApplicationTests {
	
	@Autowired
	AccountRepo accRepo;
	
	@Autowired
	CustomerRepo custRepo;
	
	@Test
	public void testAddAccount() {
		Boolean check = true;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("../linkaja/src/main/resources/InsertAccJson.json"));

			AccountDto[] dtoArr = mapper.readValue(obj.toString(), AccountDto[].class);
			
			List<AccountDto> accList = new ArrayList(Arrays.asList(dtoArr));
			
			AccountModel acc;
			for(AccountDto accDto: accList) {
				acc = new AccountModel(); 
				acc.setAccountNumber( Long.parseLong(accDto.getAccountNumber()));
				acc.setCustomerNumber(accDto.getCustomerNumber());
				acc.setBalance(accDto.getBalance());
				
				accRepo.save(acc);
				verify(accRepo, times(1)).save(acc);
			}
			
			 
		}catch(Exception e) {
			e.printStackTrace();
			check = false;
		}
		assertTrue(check);
	}
	
	
	@Test
	public void testAddCustomer() {
		Boolean check = true;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("../linkaja/src/main/resources/InsertCustJson.json"));

			CustomerDto[] dtoArr = mapper.readValue(obj.toString(), CustomerDto[].class);
			
			List<CustomerDto> accList = new ArrayList(Arrays.asList(dtoArr));
			
			CustomerModel acc;
			for(CustomerDto custDto: accList) {
				acc = new CustomerModel(); 
				acc.setCustomerNumber( Long.parseLong(custDto.getCustomerNumber()));
				acc.setName(custDto.getCustomerNumber());
				
				custRepo.save(acc);
				verify(custRepo, times(1)).save(acc);
			}
		}catch(Exception e) {
			e.printStackTrace();
			check = false;
		}
		assertTrue(check);
	}

}
