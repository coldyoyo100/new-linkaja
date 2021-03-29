package com.onlinetest.linkaja.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferDto {
	
	@JsonProperty("to_account_number")
	private String toAccountNumber;
	
	private String amount;

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
