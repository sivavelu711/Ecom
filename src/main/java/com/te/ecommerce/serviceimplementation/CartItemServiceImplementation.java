package com.te.ecommerce.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.exception.CartItemException;
import com.te.ecommerce.repository.CartItemRepository;
import com.te.ecommerce.repository.CartRepository;
import com.te.ecommerce.repository.ProductRepository;
import com.te.ecommerce.service.CartItemService;

@Service
public class CartItemServiceImplementation implements CartItemService {
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CartRepository cartRepository;


	@Override
	public CartItem cartItemCreation(CartItemDto cartItemDto) {
		Product product = new Product();
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(cartItemDto, product);
		Product save = productRepository.findById(product.getId()).orElse(null);
		BeanUtils.copyProperties(save, cartItem);
		// CartItem cartadd = new CartItem();
		cartItem.setQuantity(cartItemDto.getQuantity());
		cartItem.setPrice(save.getPrice() * cartItemDto.getQuantity());
		CartItem cartadd = cartItemRepository.save(cartItem);
		// calculation();
		if (cartadd != null) {
			return cartadd;
		}
		throw new CartItemException("CartItem not created");
	}

//	public CartItem calculation() {
//		Product save=new Product();
//		cartItem.setQuantity(cartItemDto.getQuantity());
//		cartItem.setPrice(save.getPrice() * cartItemDto.getQuantity());
//		CartItem cartadd = cartItemRepository.save(cartItem);
//		return cartadd;
//	}

	@Override
	public CartItem cartItemFetching(CartItemDto cartItemDto) {
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(cartItemDto, cartItem);
		List<CartItem> findAll = cartItemRepository.findAll();
		for (CartItem cart : findAll) {
			if (cartItemDto.getId().equals(cart.getId())) {
				return cart;
			}
		}
		throw new CartItemException("Cartitem can't fetched");
	}

	@Override
	public CartItem cartItemUpdation(CartItemDto cartItemDto) {
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(cartItemDto, cartItem);
		CartItem updateDetail = cartItemRepository.findById(cartItem.getId()).orElse(null);
		if (updateDetail != null) {
			cartItem.setId(cartItemDto.getId());
			cartItem.setQuantity(cartItemDto.getQuantity());
			cartItem.setPrice(cartItemDto.getPrice());
			cartItemRepository.save(cartItem);
			return cartItem;

		}
		throw new CartItemException("Cartitem can't Updated");
	}

	@Override
	public String cartItemsDeleting(CartItemDto cartItemDto) {
		CartItem cartItem = new CartItem();
		BeanUtils.copyProperties(cartItemDto, cartItem);
		CartItem deleteDetail = cartItemRepository.findById(cartItem.getId()).orElse(null);
		if (deleteDetail != null) {
			cartItemRepository.delete(deleteDetail);
			return null;
		}
		throw new CartItemException("Unable to delete product");
	}

	@Override
	public Cart cartCalculation(CustomerDto customerDto) {

		Cart cart = new Cart();
		List<Double> collect = cartItemRepository.findAll()
				.stream()
				.filter(cartCreated -> cartCreated.getPrice() > 0)
				.map(CartItem::getPrice)
				.collect(Collectors.toList());

		Double grandTotal = 0.0;

//		 cart.setTotalPrice(collect);
		for (Double grand : collect) {
			grandTotal += grand;

		}
        cart.setId(customerDto.getId());
		cart.setTotalPrice(grandTotal);
		Cart save = cartRepository.save(cart);
		return save;
	}


//		 productsList.stream()  
//         .filter(product -> product.price >=000)  
//         .forEach(product -> System.out.println(product.name));  

}
