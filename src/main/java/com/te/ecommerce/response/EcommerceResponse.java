package com.te.ecommerce.response;

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
public class EcommerceResponse {
	private String message;
	private boolean error;
	private String status;
	private Object data;

}
