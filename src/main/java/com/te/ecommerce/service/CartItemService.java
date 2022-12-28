package com.te.ecommerce.service;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;

public interface CartItemService {

	CartItem cartItemCreation(CartItemDto cartItemDto);

	CartItem cartItemFetching(CartItemDto cartItemDto);

	CartItem cartItemUpdation(CartItemDto cartItemDto);

	String cartItemsDeleting(CartItemDto cartItemDto);

	Cart cartCalculation(CustomerDto customerDto);


}
