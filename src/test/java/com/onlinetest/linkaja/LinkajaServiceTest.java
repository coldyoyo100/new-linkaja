package com.onlinetest.linkaja;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlinetest.linkaja.dto.TransferDto;
import com.onlinetest.linkaja.model.AccountModel;
import com.onlinetest.linkaja.model.CustomerModel;
import com.onlinetest.linkaja.repository.AccountRepo;
import com.onlinetest.linkaja.repository.CustomerRepo;
import com.onlinetest.linkaja.service.LinkAjaService;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class LinkajaServiceTest {

	@Mock
	AccountRepo accRepo;
	
	@Mock
	CustomerRepo custRepo;
	
	@Test
	public void testGetAccOne() {
		AccountModel accModel = accRepo.getOne(Long.parseLong("555001"));
//		when(accRepo.getOne(any(Long.class))).thenReturn(accModel);

		verify(accRepo).getOne(Long.parseLong("555001"));
	}
	
	@Test
	public void testGetCustOne() {
		CustomerModel custModel= custRepo.getOne(Long.parseLong("555002"));
//		when(custRepo.getOne(any(Long.class))).thenReturn(custModel);
		
		verify(custRepo).getOne(Long.parseLong("555002"));
	}
	
	@Test
	public void testCountAcc() {
		int count = accRepo.countSize();
//		when(accRepo.countSize()).thenReturn(count);
		assertNotNull(count);
	}
	
	@Test
	public void testCountCust() {
		int count = custRepo.countSize();
//		when(accRepo.countSize()).thenReturn(count);
		assertNotNull(count);
	}
	
	
	@Test
	public void testGetAccInfo() {
		AccountModel accModel = accRepo.getInfoByAccNo("8888");
		verify(accRepo, times(1)).getInfoByAccNo("8888");
	}
	
	@Test
	public void testGetCustNameById() {
		String custName= custRepo.getNameByCustNo("555002");
		
		verify(custRepo, times(1)).getNameByCustNo("555002");
	}
	
}
