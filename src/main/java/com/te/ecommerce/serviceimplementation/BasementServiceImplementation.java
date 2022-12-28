package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.exception.CustomerException;
import com.te.ecommerce.repository.CustomerRepository;
import com.te.ecommerce.service.BasementService;

@Service
public class BasementServiceImplementation implements BasementService {
	@Autowired
	private CustomerRepository customerRepository;
//	@Autowired
//	private CartItemRepository cartItemRepository;
//	@Autowired
//	private CartRepository cartRepository;

	@Override
	public Boolean  register(Customer customer) {
		Customer register=customerRepository.save(customer);
		// CartCreation(customer.getId());
		if (register != null) {
			return true;
			
		}
			throw new CustomerException(" unable to Registration");

	}
	
//	// CreateCart
//	public Cart CartCreation(@PathVariable String Id) {
//		Cart cart = new Cart();
//		List<Double> collect = cartItemRepository.findAll()
//				.stream()
//				.filter(cartCreated -> cartCreated.getPrice() > 0)
//				.map(CartItem::getPrice)
//				.collect(Collectors.toList());
//
//		Double grandTotal = 0.0;
//
////		 cart.setTotalPrice(collect);
//		for (Double grand : collect) {
//			grandTotal += grand;
//
//		}
//
//		cart.setTotalPrice(grandTotal);
//		Cart save = cartRepository.save(cart);
//		return save;
//
//	}

}
