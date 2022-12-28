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
import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.response.EcommerceResponse;
import com.te.ecommerce.service.ProductService;

@RestController
public class ManagerController {
	@Autowired
	private EcommerceResponse ecommerceResponse;
	@Autowired
	private ProductService productService;

	// CreateProduct API
	@PostMapping("/createProductDetails")
	public ResponseEntity<EcommerceResponse> createProductData(@RequestBody ProductDto productDto) {
		boolean addProduct = productService.createProduct(productDto);
		ecommerceResponse.setMessage("Product details added successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(addProduct);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// ReadProductDetails API
	@GetMapping("/getProductDetails")
	public ResponseEntity<EcommerceResponse> getProductDetails(@RequestBody ProductDto productDto) {
		Product readData = productService.getProductDetails(productDto);
		ecommerceResponse.setMessage("Product details fetched successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(readData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// UpdateProductDetails
	@PutMapping("/updateProductDetails")
	public ResponseEntity<EcommerceResponse> updateProductDetails(@RequestBody ProductDto productDto) {
		Product updateData = productService.updateProductDetails(productDto);
		ecommerceResponse.setMessage("Product details Updated successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(updateData);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);
	}

	// DeleteProductdetails API
	@DeleteMapping("/deleteProductDetails")
	public ResponseEntity<EcommerceResponse> deleteProductDetails(@RequestBody ProductDto productDto) {
		String productDelete = productService.deleteProductDetails(productDto);
		ecommerceResponse.setMessage("Product details Deleted successfully");
		ecommerceResponse.setStatus("200");
		ecommerceResponse.setError(false);
		ecommerceResponse.setData(productDelete);
		return new ResponseEntity<EcommerceResponse>(ecommerceResponse, HttpStatus.ACCEPTED);

	}
	
	
}
