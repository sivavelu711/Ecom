package com.te.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class SalesOrder {
	@Id
	private String id;

	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private BillingAddress billingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

}
