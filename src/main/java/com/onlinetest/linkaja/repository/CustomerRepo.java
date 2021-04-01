package com.onlinetest.linkaja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinetest.linkaja.model.CustomerModel;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<CustomerModel, Long>{
	
	@Query(value = "SELECT cust.* FROM customer cust WHERE cust.customer_number = :custNo", nativeQuery = true)
	String getNameByCustNo(@Param("custNo") String custNo);
	
	@Query(value="SELECT count(cust.1) FROM customer cust", nativeQuery = true)
	int countSize();
}
