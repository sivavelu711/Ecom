package com.te.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CartItemFetchDto;
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

	
	//CreateCartItemDetails
	@PostMapping("/cartItemCreation")
	public ResponseEntity<EcommerceResponse> cartItemCreation(@RequestBody CartItemDto cartItemDto){
		List<CartItem> createCartItem= cartItemService.cartItemCreation(cartItemDto);
		ecommerceResponse.setMessage("Cart details added successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(createCartItem);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	//ReadCartItemDetails
	@PostMapping("/cartItemFetching")
	public ResponseEntity<EcommerceResponse> cartItemFetching(@RequestBody CartItemFetchDto cartItemDto){
		CartItem fetchCartItem=cartItemService.cartItemFetching(cartItemDto);
		ecommerceResponse.setMessage("Cart details fetched successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(fetchCartItem);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// DeleteCartItemdetails API
	@DeleteMapping("/deleteCartItemDetails")
	public ResponseEntity<EcommerceResponse> cartItemsDeleting(@RequestBody CartItemFetchDto cartItemDto) {
		String cartItemDelete = cartItemService.cartItemsDeleting(cartItemDto);
		ecommerceResponse.setMessage("CartItem Deleted successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(cartItemDelete);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	
	//CreateCartDetails
	@PostMapping("/cartCalculation")
	public ResponseEntity<EcommerceResponse> cartCalculation(@RequestBody CustomerDto customerDto){
		Cart cartCalculation= cartItemService.cartCalculation(customerDto);
		ecommerceResponse.setMessage("CartItem details Calculated");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(cartCalculation);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}
	@PostMapping("/getAllProduct")
	public ResponseEntity<EcommerceResponse> getAllCartItems(@RequestBody CartItemFetchDto cartItemDto) {
		List<CartItem> findAll = cartItemService.getAllCartItems(cartItemDto);
		ecommerceResponse.setError(false);
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setData(findAll);
		return new ResponseEntity<>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
}
	
	

