package com.te.ecommerce.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.CartItemDto;
import com.te.ecommerce.dto.CartItemFetchDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Cart;
import com.te.ecommerce.entity.CartItem;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.exception.CartItemException;
import com.te.ecommerce.repository.CartItemRepository;
import com.te.ecommerce.repository.CartRepository;
import com.te.ecommerce.repository.CustomerRepository;
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
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private Customer customer;
	@Autowired
	private Product product;
	@Autowired
	private CartItem cartItem;

	@Override
	public List<CartItem> cartItemCreation(CartItemDto cartItemDto) {
		BeanUtils.copyProperties(cartItemDto, product);
		Product save = productRepository.findById(product.getId())
				.orElseThrow(() -> new CartItemException("CartItem not created"));
		BeanUtils.copyProperties(save, cartItem);
		BeanUtils.copyProperties(cartItemDto, customer);
		Optional<Customer> findById = customerRepository.findById(customer.getCustomerId());
		if (findById.isPresent()) {
			Customer custom = findById.get();
			
			cartItem.setQuantity(cartItemDto.getQuantity());
			cartItem.setCustomer(custom);
			cartItem.setPrice(save.getPrice() * cartItemDto.getQuantity());
		}
		CartItem item = cartItemRepository.save(cartItem);
		List<CartItem> cartItems=new ArrayList<>();
		cartItems.add(item);
		return cartItems;
	}

	@Override
	public CartItem cartItemFetching(CartItemFetchDto cartItemDto) {
		BeanUtils.copyProperties(cartItemDto, cartItem);
		List<CartItem> findAll = cartItemRepository.findAll();
		BeanUtils.copyProperties(cartItemDto, customer);
		Optional<Customer> findById = customerRepository.findById(customer.getCustomerId());

		if (findById.isPresent()) {
			Customer custom = findById.get();

			for (CartItem cart : findAll) {
				if (cartItemDto.getCustomerId().equals(custom.getCustomerId())) {
					return cart;
				}
			}
		}
		throw new CartItemException("Cartitem can't fetched");
	}

	@Override
	public String cartItemsDeleting(CartItemFetchDto cartItemDto) {
		BeanUtils.copyProperties(cartItemDto, cartItem);
		CartItem deleteDetail = cartItemRepository.findById(cartItem.getCartItemId()).orElse(null);
		Optional<Customer> findById = customerRepository.findById(customer.getCustomerId());
		if (findById.isPresent()) {
			Customer custom = findById.get();
			if (cartItemDto.getCustomerId().equals(custom.getCustomerId())) {
				cartItemRepository.delete(deleteDetail);
				return null;
			}
		}
		throw new CartItemException("Unable to delete product");
	}

	@Override
	public Cart cartCalculation(CustomerDto customerDto) {
		Cart cart = new Cart();
		Optional<Customer> findById = customerRepository.findById(customer.getCustomerId());
		if (findById.isPresent()) {
			Customer custom = findById.get();
			if (customerDto.getCustomerId().equals(custom.getCustomerId())) {

				List<Double> collect = cartItemRepository.findAll().stream()
						.filter(cartCreated -> cartCreated.getPrice() > 0).map(CartItem::getPrice)
						.collect(Collectors.toList());

				Double grandTotal = collect.stream().reduce(0.0, (pricefetch, price) -> pricefetch + price);
				cart.setCartId(customerDto.getCustomerId());
				cart.setTotalPrice(grandTotal);
				Cart save = cartRepository.save(cart);
				if (save != null) {
					return save;
				}
			}
		}
		throw new CartItemException("Unable to Calculate product");
	}

	@Override
	public List<CartItem> getAllCartItems(CartItemFetchDto cartItemDto) {
		BeanUtils.copyProperties(cartItemDto, cartItem);
		BeanUtils.copyProperties(cartItemDto, customer);
		Optional<Customer> findById = customerRepository.findById(customer.getCustomerId());
		if (findById.isPresent()) {
			Customer custom = findById.get();
		return cartItemRepository.findAll().stream()
				.filter(cart-> cart.getCustomer().equals(findById.get()))
				.collect(Collectors.toList());
		
//		CartItem getAllDetal = cartItemRepository.findById(cartItem.getCartItemId()).orElse(null);
//		Optional<Customer> findById = customerRepository.findById(customer.getCustomerId());
//		if (findById.isPresent()) {
//			Customer custom = findById.get();
//			if (cartItemDto.getCustomerId().equals(custom.getCustomerId())) {

			}
		
		throw new CartItemException("Unable to Calculate product");
	}
}
