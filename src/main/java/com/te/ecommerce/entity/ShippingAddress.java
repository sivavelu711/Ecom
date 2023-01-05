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
public class ShippingAddress {
	@Id
	private String id; 
	private String address; 
	private String city; 
	private String state; 
	private int zipcode; 
	private String country;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Customer customer;
	

}
