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
		// password need to generate by spring security
		BeanUtils.copyProperties(customer, customer);
		Customer save = customerRepository.save(customer);
		if (save != null) {
			return true;
		}
		throw new CustomerException("register not setup,please valid correct data ");
	}

	@Override
	public Customer customerDetailsReading(CustomerDto customerDto) {

		BeanUtils.copyProperties(customerDto, customer);
		Customer getDetail = customerRepository.findById(customer.getId()).orElse(null);
		if (getDetail != null) {
			return getDetail;
		}
		throw new CustomerException("Unable to read Customer details");
	}

	@Override
	public Customer customerDetailsUpdating(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		Customer updateDetail = customerRepository.findById(customer.getId()).orElse(null);
		if (updateDetail != null) {
			customer.setFirstName(customerDto.getFirstName());
			customer.setLastName(customerDto.getLastName());
			customer.setCustomerPhone(customerDto.getCustomerPhone());
			customer.setId(customerDto.getId());
			customerRepository.save(customer);
			return customer;
		}
		throw new CustomerException("Unable to update Customer details");
	}

	@Override
	public String customerDetailsDeleting(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		Customer deleteDetail = customerRepository.findById(customer.getId()).orElse(null);
		if (deleteDetail != null) {
			customerRepository.delete(deleteDetail);
			return null;
		}
		throw new CustomerException("Unable to delete Customer details");
	}

}
