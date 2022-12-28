package com.te.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
	@Id
	private String id;
	private String emailId;
	private String password;
	private boolean enabled;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Customer customer;

}
