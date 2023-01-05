package com.te.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Data
@Component
public class User {
	@Id
	private String username;
	private String password;
	@Column(name = "account_non_locked")
	private boolean accountNonLocked;

}