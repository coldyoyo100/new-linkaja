package com.onlinetest.linkaja.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

@Entity
@Table(name="account")
public class AccountModel {
	
	@Id
	@Column(name="account_number")
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long accountNumber;
	
//	@JoinColumn(name="cust_id")
	@Column(name="customer_number")
	private String customerNumber;
	
	@NotNull
	private int balance;

//	@NotNull
//	@JoinColumn(name="cust_id")
//	@Column(name="customer_number")
//	private Set<CustomerModel> customerSet = new HashSet<CustomerModel>();
	
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	
	
	public String getCustomerNumber() {
		return customerNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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
		builder.append("{");
		builder.append("\"accountNumber\":");
		builder.append("\"").append(accountNumber).append("\",");
		builder.append("\"customerNumber\":");
		builder.append("\"").append(customerNumber).append("\",");
		builder.append("\"balance\":");
		builder.append(balance);
		builder.append("}");
		return builder.toString();
	}
	
	
}
