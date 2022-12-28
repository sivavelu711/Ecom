package com.te.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class BillingAddress {
	@Id
	private String id; 
	private String address; 
	private String city; 
	private String state; 
	private int zipcode; 
	private String country; 
	
//	@OneToOne(mappedBy = "billingAddress")
//	private Customer customer;
//	
//	@OneToOne(mappedBy = "billingAddress")
//	private SalesOrder salesOrder;


}
