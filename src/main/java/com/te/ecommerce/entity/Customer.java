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
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
public class Customer {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private long customerPhone;
//	private String shippingAddressId;
//	private String billingAddressId;
//	private String userId;
//	private String cartId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	@OneToOne(cascade = CascadeType.ALL)
	private BillingAddress billingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
//	@OneToOne(cascade = CascadeType.ALL)
//	private SalesOrder salesOrder;
	
}
