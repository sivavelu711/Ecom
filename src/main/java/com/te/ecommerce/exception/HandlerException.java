package com.te.ecommerce.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.ecommerce.response.EcommerceResponse;

@ControllerAdvice
public class HandlerException {
	@Autowired
	EcommerceResponse ecommerceResponse;
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<EcommerceResponse> productException(ProductException productException){
		ecommerceResponse.setMessage(productException.getErrorMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<EcommerceResponse> CustomerException(CustomerException customerException){
		ecommerceResponse.setMessage(customerException.getErrorMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(CartItemException.class)
	public ResponseEntity<EcommerceResponse> CartItemException(CartItemException cartItemException){
		ecommerceResponse.setMessage(cartItemException.getErrorMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(ShippingAddressException.class)
	public ResponseEntity<EcommerceResponse> shippingAddressException(ShippingAddressException shippingAddressException){
		ecommerceResponse.setMessage(shippingAddressException.getErrorMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	@ExceptionHandler(BillingAddressException.class)
	public ResponseEntity<EcommerceResponse> shippingAddressException(BillingAddressException billingAddressException){
		ecommerceResponse.setMessage(billingAddressException.getErrorMessage());
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

}
