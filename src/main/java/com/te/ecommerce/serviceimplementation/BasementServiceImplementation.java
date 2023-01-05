package com.te.ecommerce.serviceimplementation;

import org.springframework.stereotype.Service;

import com.te.ecommerce.service.BasementService;

@Service
public class BasementServiceImplementation implements BasementService {

//	@Autowired
//	private UserRepository userRepository;


//	@Override
//	public Boolean  register(Customer customer) {
//		Customer register=basementService.save(customer);
//		
//		if (register != null) {
//			return true;
//			
//		}
//			throw new CustomerException(" unable to Registration");
//
//	}
	
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
//	@Override
//	public User login(UserDto userDto) {
//		User user = new User();
//		BeanUtils.copyProperties(userDto, user);
//		User userdata=userRepository.findById(user.getUsername())
//				.orElseThrow(() -> new CustomerException(" Unable to login "));
//		if((userdata.isEnabled())|| (user.isAccountNonLocked())) 
//			return userdata;
//		return null;
//	}


}
