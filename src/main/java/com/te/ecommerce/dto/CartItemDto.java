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
public class CartItemDto {
	//private String cartItemId;
	//productId
	private String id;
	private Integer quantity;
	private String customerId;
	
	
}
