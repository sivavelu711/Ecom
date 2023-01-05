package com.te.ecommerce.service;

import java.util.List;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CartItemFetchDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;

public interface CartItemService {

	List<CartItem> cartItemCreation(CartItemDto cartItemDto);

	CartItem cartItemFetching(CartItemFetchDto cartItemDto);

	Cart cartCalculation(CustomerDto customerDto);

	List<CartItem> getAllCartItems(CartItemFetchDto cartItemDto);

	String cartItemsDeleting(CartItemFetchDto cartItemDto);


}
