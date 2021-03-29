package com.onlinetest.linkaja.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountInfoDto {
	
	@JsonProperty("account_number")
	private String accountNumber;
	
	@JsonProperty("customer_name")
	private String customerName;
	
	private int balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"accountNumber\": \"");
		builder.append(accountNumber);
		builder.append("\", \"customerName\": \"");
		builder.append(customerName);
		builder.append("\", \"balance\": ");
		builder.append(balance);
		builder.append("}");
		return builder.toString();
	}
	
	
}
