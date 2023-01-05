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
	private String cartId;
	private double totalPrice;
}
