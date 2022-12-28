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
public class Cart {
	@Id
	private String id;
	private double totalPrice;
	
//    @OneToOne(cascade = CascadeType.ALL)
//	private Customer customer;
    
//    @OneToOne(cascade = CascadeType.ALL)
//	private SalesOrder salesOrder;
//    
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<CartItem> cartItem;
	
}
