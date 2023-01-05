package com.te.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ecommerce.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	
}
