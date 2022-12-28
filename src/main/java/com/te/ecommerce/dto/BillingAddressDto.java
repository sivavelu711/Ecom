package com.te.ecommerce.dto;

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
public class BillingAddressDto {
	private String id; 
	private String address; 
	private String city; 
	private String state; 
	private int zipcode; 
	private String country;

}
