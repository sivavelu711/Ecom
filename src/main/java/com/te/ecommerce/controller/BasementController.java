package com.te.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.response.EcommerceResponse;
import com.te.ecommerce.service.CustomerService;

@RestController
public class BasementController {
	@Autowired
	private EcommerceResponse ecommerceResponse;
	@Autowired
	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<EcommerceResponse> register(@RequestBody Customer customer) {
		
		Boolean register = customerService.register(customer);

		ecommerceResponse.setMessage("Thanks for registeration");
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(register);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.CREATED);
	}
//	public ResponseEntity<EcommerceResponse> login(@RequestBody UserDto userDto) {
//		User login = customerService.login(userDto);
//		ecommerceResponse.setMessage("logged in successfully");
//		ecommerceResponse.setData(login);
//		return new ResponseEntity<>(ecommerceResponse, HttpStatus.ACCEPTED);
//	}
}
