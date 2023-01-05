package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.exception.CustomerException;
import com.te.ecommerce.repository.CustomerRepository;
import com.te.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public Boolean register(Customer customer) {
		Customer save = customerRepository.save(customer);
		
		if (save != null) {
			return true;
		}
		throw new CustomerException("register not setup,please valid correct data ");
	}

	@Override
	public Customer customerDetailsReading(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		return customerRepository.findById(customer.getCustomerId())
				.orElseThrow(() -> new CustomerException("Unable to read Customer details"));
	}

	@Override
	public Customer customerDetailsUpdating(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		Customer updateDetail = customerRepository.findById(customer.getCustomerId())
				.orElseThrow(()->new CustomerException("Unable to update Customer details"));

			customer.setCustomerId(customerDto.getCustomerId());
			customerRepository.save(customer);
			return updateDetail;
	}

	@Override
	public Customer customerDetailsDeleting(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		Customer delete = customerRepository.findById(customer.getCustomerId()).orElseThrow(()->new CustomerException("Unable to delete Customer details"));
			customerRepository.delete(delete);
			return null;
		}

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
