package com.te.ecommerce.service;

import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.entity.Product;

public interface ProductService {

	boolean createProduct(ProductDto productDto);

	Product getProductDetails(ProductDto productDto);

	Product updateProductDetails(ProductDto productDto);

	String deleteProductDetails(ProductDto productDto);

}
