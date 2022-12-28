package com.te.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.dto.CustomerDto;
import com.te.ecommerce.dto.ShippingAddressDto;
import com.te.ecommerce.entity.BillingAddress;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.ShippingAddress;
import com.te.ecommerce.response.EcommerceResponse;
import com.te.ecommerce.service.BillingAddressService;
import com.te.ecommerce.service.CustomerService;
import com.te.ecommerce.service.ShippingAddressService;

@RestController
public class CustomerController {
	@Autowired
	private EcommerceResponse ecommerceResponse;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ShippingAddressService shippingAddressService;
	@Autowired
	private BillingAddressService billingAddressService;

	// ReadCustomerDetails API (NEED TO ACCESS BY ALL)
	@GetMapping("/getCustomerDetails")
	public ResponseEntity<EcommerceResponse> customerDetailsReading(@RequestBody CustomerDto customerDto) {
		Customer readData = customerService.customerDetailsReading(customerDto);
		ecommerceResponse.setMessage("Customer details fetched successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(readData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// UpdateCustomerDetails
	@PutMapping("/updateCustomerDetails")
	public ResponseEntity<EcommerceResponse> customerDetailsUpdating(@RequestBody CustomerDto customerDto) {
		Customer updateData = customerService.customerDetailsUpdating(customerDto);
		ecommerceResponse.setMessage("Customer details Updated successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(updateData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// DeleteCustomerdetails API
	@DeleteMapping("/deleteCustomerDetails")
	public ResponseEntity<EcommerceResponse> customerDetailsDeleting(@RequestBody CustomerDto customerDto) {
		String customerDelete = customerService.customerDetailsDeleting(customerDto);
		ecommerceResponse.setMessage("Customer details Deleted successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(customerDelete);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// CreateShippingAddress API
	@PostMapping("/createShippingAddress")
	public ResponseEntity<EcommerceResponse> shippingAddressCreation(
			@RequestBody ShippingAddressDto shippingAddressDto) {
		boolean addProduct = shippingAddressService.shippingAddressCreation(shippingAddressDto);
		ecommerceResponse.setMessage("ShippingAddress details added successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(addProduct);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// ReadShippingAddress API
	@GetMapping("/getShippingAddress")
	public ResponseEntity<EcommerceResponse> shippingAddressFetching(
			@RequestBody ShippingAddressDto shippingAddressDto) {
		ShippingAddress readData = shippingAddressService.shippingAddressFetching(shippingAddressDto);
		ecommerceResponse.setMessage("ShippingAddress details fetched successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(readData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// UpdateShippingAddressrDetails
	@PutMapping("/updateShippingAddress")
	public ResponseEntity<EcommerceResponse> shippingAddressUpdating(
			@RequestBody ShippingAddressDto shippingAddressDto) {
		ShippingAddress updateData = shippingAddressService.shippingAddressUpdating(shippingAddressDto);
		ecommerceResponse.setMessage("ShippingAddress details Updated successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(updateData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// DeleteShippingAddress API
	@DeleteMapping("/deleteShippingAddress")
	public ResponseEntity<EcommerceResponse> shippingAddressDeleting(
			@RequestBody ShippingAddressDto shippingAddressDto) {
		String customerDelete = shippingAddressService.shippingAddressDeleting(shippingAddressDto);
		ecommerceResponse.setMessage("ShippingAddress details Deleted successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(customerDelete);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// CreateBillingAddress API
	@PostMapping("/createBillingAddress")
	public ResponseEntity<EcommerceResponse> billingAddressCreation(@RequestBody BillingAddressDto billingAddressDto) {
		boolean addProduct = billingAddressService.billingAddressCreation(billingAddressDto);
		ecommerceResponse.setMessage("billingAddress details added successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(addProduct);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// ReadBillingAddress API
	@GetMapping("/getBillingAddress")
	public ResponseEntity<EcommerceResponse> billingAddressFetching(@RequestBody BillingAddressDto billingAddressDto) {
		BillingAddress readData = billingAddressService.billingAddressFetching(billingAddressDto);
		ecommerceResponse.setMessage("BillingAddress details fetched successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(readData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// UpdateBillingAddressrDetails
	@PutMapping("/updateBillingAddress")
	public ResponseEntity<EcommerceResponse> billingAddressUpdating(@RequestBody BillingAddressDto billingAddressDto) {
		BillingAddress updateData = billingAddressService.billingAddressUpdating(billingAddressDto);
		ecommerceResponse.setMessage("billingAddress details Updated successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(updateData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// DeleteShippingAddress API
	@DeleteMapping("/deleteBillingAddress")
	public ResponseEntity<EcommerceResponse> billingAddressDeleting(@RequestBody BillingAddressDto billingAddressDto) {
		String customerDelete = billingAddressService.billingAddressDeleting(billingAddressDto);
		ecommerceResponse.setMessage("BillingAddress details Deleted successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(customerDelete);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

}
