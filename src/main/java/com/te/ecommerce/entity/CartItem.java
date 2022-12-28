package com.te.ecommerce.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class CartItem {
	@Id
	private String id;
	private int quantity;
	private double price;
//	private String cartId;
//	private String productId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cart cart;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> product;

}
