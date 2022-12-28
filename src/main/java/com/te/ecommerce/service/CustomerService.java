package com.te.ecommerce.service;

import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.entity.Customer;

public interface CustomerService {

	Customer customerDetailsReading(CustomerDto customerDto);

	Customer customerDetailsUpdating(CustomerDto customerDto);

	String customerDetailsDeleting(CustomerDto customerDto);

	Boolean register(Customer customer);

}
