package com.onlinetest.linkaja;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.onlinetest.linkaja.controller.LinkAjaController;
import com.onlinetest.linkaja.dto.TransferDto;
import com.onlinetest.linkaja.service.LinkAjaService;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
public class LinkajaControllerTest {
	
	@InjectMocks
	LinkAjaController linkController;
	
	@Mock
	LinkAjaService linkService;
	
	@Test
	public void testGetAccInfo() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(linkService.getAccInfo(any(String.class))).thenReturn("true");
        
        String accNo = "12";
		try {
			ResponseEntity<?> responseEntity = linkController.getAccNoInfo(accNo);
			
			assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCodeValue());
			System.out.println( responseEntity .getBody().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
         
        
	}
	
	@Test
	public void testTransfer() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        ResponseEntity<?> responseEntity;
        try {
			when(linkService.transferAccSeq(any(String.class), any(TransferDto.class))).thenReturn("true");
		
			TransferDto transDto = new TransferDto();
	        transDto.setToAccountNumber("555001");
	        transDto.setAmount("10000");
	        
	        responseEntity = linkController.transferAction("2131", transDto);
	        
	        assertEquals(HttpStatus.OK.value(),responseEntity.getStatusCodeValue());
        } catch (Exception e) {
			e.printStackTrace();
		}
        
        
	}

}
