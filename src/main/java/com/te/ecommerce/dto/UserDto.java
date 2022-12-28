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
public class UserDto {
	private String id;
	private String emailId;
	private String password;
	private boolean enabled;

}
