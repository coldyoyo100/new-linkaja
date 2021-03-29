package com.onlinetest.linkaja.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.onlinetest.linkaja.dto.AccountDto;
import com.onlinetest.linkaja.dto.AccountInfoDto;
import com.onlinetest.linkaja.dto.CustomerDto;
import com.onlinetest.linkaja.dto.TransferDto;
import com.onlinetest.linkaja.model.AccountModel;
import com.onlinetest.linkaja.model.CustomerModel;
import com.onlinetest.linkaja.repository.AccountRepo;
import com.onlinetest.linkaja.repository.CustomerRepo;

@Service
public class LinkAjaService {
	
	Logger log = LoggerFactory.getLogger(LinkAjaService.class);
	
	@Autowired
	AccountRepo accRepo;
	
	@Autowired
	CustomerRepo custRepo;
	
	public String addAccount(List<AccountDto> accArr) throws Exception {
		AccountModel acc;
//		CustomerModel custModel;
		for(AccountDto accDto : accArr) {
			acc = new AccountModel(); 
			acc.setAccountNumber( Long.parseLong(accDto.getAccountNumber()));
			acc.setCustomerNumber(accDto.getCustomerNumber());
			acc.setBalance(accDto.getBalance());

//			
//			custModel = new CustomerModel();
//			custModel.setCustomerNumber(accDto.getCustomerNumber());
//			
//			Set<CustomerModel> custSet = new HashSet<CustomerModel>();
//			custSet.add(custModel);
			log.info(acc.toString());
			accRepo.save(acc);
		}
		
		return "Insert Account Sukses";
	}
	
	public String addCustomer(List<CustomerDto> custArr) throws Exception {
		CustomerModel customer;
		for(CustomerDto custDto : custArr) {
			customer = new CustomerModel();
			customer.setCustomerNumber( Long.parseLong(custDto.getCustomerNumber()));
			customer.setName(custDto.getName());
			custRepo.save(customer);
		}
		custRepo.flush();
		return "Insert Customer Sukses";
	}
	
	public String updateAmount(String fromAcc, int amount, String destAcc) throws Exception{
		String retval = null;
		List<AccountModel> accInfo = accRepo.getInfoByAccNo(fromAcc);
		
		for(AccountModel accModel : accInfo) {
			int balance = accModel.getBalance();
			int newBalance = balance - amount;
			if(newBalance < 0) {
				retval = "Balance tidak cukup";
			}else {
				accModel.setBalance(newBalance); //update balance
				accRepo.save(accModel);
				
				updtDestAcc(destAcc, balance);
			}
		}
		
		return retval;
	}
	
	
	public void updtDestAcc(String destAcc, int transferBalance) throws Exception {
		List<AccountModel> accList = accRepo.getInfoByAccNo(destAcc);
		
		for(AccountModel accModel : accList) {
			int addBalance = accModel.getBalance() + transferBalance;
			accModel.setBalance(addBalance);
			accRepo.save(accModel);
		}
	}
	
	public String getAccInfo(String accNo) {
		List<AccountModel> accList = accRepo.getInfoByAccNo(accNo);
		
		AccountInfoDto infoDto = new AccountInfoDto();
		
		for(AccountModel accModel : accList) {
			infoDto.setAccountNumber(String.valueOf(accModel.getAccountNumber()));
			infoDto.setBalance(accModel.getBalance());
			
			String custNo = accModel.getCustomerNumber();
			String custName = custRepo.getNameByCustNo(custNo);
			
			infoDto.setCustomerName(custName);
		}
		
		return infoDto.toString();
	}
	
	public String transferAccSeq(String fromAcc, TransferDto transferDto) throws Exception {
		String retval = null;
		String account = transferDto.getToAccountNumber();
		String checkAcc = accRepo.checkAccount(account);
		
		if(checkAcc.equals("1")) {
			String destAcc = transferDto.getToAccountNumber();
			int amount = Integer.valueOf(transferDto.getAmount());
			updateAmount(fromAcc, amount, destAcc);
		}else {
			retval = String.valueOf(HttpStatus.NO_CONTENT) + " - Account Tidak Terdaftar";
		}
		
		return retval;
	}
}
 