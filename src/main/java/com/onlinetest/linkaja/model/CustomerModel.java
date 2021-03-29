package com.onlinetest.linkaja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity
@Table(name="customer")
public class CustomerModel {
	
	@Id
	@Column(name="customer_number")
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long customerNumber;
	
	@NotNull
	private String name;

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"customerNumber\": \"");
		builder.append(customerNumber);
		builder.append("\", \"name\": \"");
		builder.append(name);
		builder.append("\"}");
		return builder.toString();
	}
	
	
//	@GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	
}
