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
public class ProductDto {
	private String id;
	private String category;
	private String description;
	private String manufacturer;
	private String name;
	private double price;
	private int unit;
	private int quantity;

}
