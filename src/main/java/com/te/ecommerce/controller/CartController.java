package com.te.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.response.EcommerceResponse;
import com.te.ecommerce.service.CartItemService;

@RestController
public class CartController {
	@Autowired
	private EcommerceResponse ecommerceResponse;
	@Autowired
	private CartItemService cartItemService;
//	@Autowired
//	private Cart cart;
	
	//CreateCartItemDetails
	@PostMapping("/cartItemCreation")
	public ResponseEntity<EcommerceResponse> cartItemCreation(@RequestBody CartItemDto cartItemDto){
		CartItem createCartItem= cartItemService.cartItemCreation(cartItemDto);
		ecommerceResponse.setMessage("Product details added successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(createCartItem);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	//CreateCartDetails
	@PostMapping("/cartCalculation")
	public ResponseEntity<EcommerceResponse> cartCalculation(@RequestBody CustomerDto customerDto){
		Cart cartCalculation= cartItemService.cartCalculation(customerDto);
		ecommerceResponse.setMessage("Product details added successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(cartCalculation);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	//ReadCartItemDetails
	@GetMapping("/cartItemFetching")
	public ResponseEntity<EcommerceResponse> cartItemFetching(@RequestBody CartItemDto cartItemDto){
		CartItem fetchCartItem=cartItemService.cartItemFetching(cartItemDto);
		ecommerceResponse.setMessage("Product details fetched successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(fetchCartItem);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	//UpdateCartItemDetails
	public ResponseEntity<EcommerceResponse> cartItemUpdation(@RequestBody CartItemDto cartItemDto){
		CartItem updateDetails=cartItemService.cartItemUpdation(cartItemDto);
		ecommerceResponse.setMessage("Product details Updated successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(updateDetails);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	// DeleteCartItemdetails API
	@DeleteMapping("/deleteCartItemDetails")
	public ResponseEntity<EcommerceResponse> cartItemsDeleting(@RequestBody CartItemDto cartItemDto) {
		String cartItemDelete = cartItemService.cartItemsDeleting(cartItemDto);
		ecommerceResponse.setMessage("CartItem Deleted successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(cartItemDelete);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
  

	}
	
	

