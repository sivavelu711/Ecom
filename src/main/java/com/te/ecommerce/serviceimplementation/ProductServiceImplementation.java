package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.ProductDto;
import com.te.ecommerce.entity.Product;
import com.te.ecommerce.exception.ProductException;
import com.te.ecommerce.repository.ProductRepository;
import com.te.ecommerce.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Product product;

	@Override
	public boolean createProduct(ProductDto productDto) {
		BeanUtils.copyProperties(productDto, product);
		product.setCategory(productDto.getCategory());
		product.setDescription(productDto.getDescription());
		product.setManufacturer(productDto.getManufacturer());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setUnit(productDto.getUnit());

		Product save = productRepository.save(product);
		if (save != null) {
			return true;
		} 
			throw new ProductException("Product not created");
		
	}

	@Override
	public Product getProductDetails(ProductDto productDto) {
		BeanUtils.copyProperties(productDto, product);
		Product getDetail = productRepository.findById(product.getId()).orElse(null);
		if (getDetail != null) {
			return getDetail;
		} 
			throw new ProductException("Unable to fetch that product");
	}

	@Override
	public Product updateProductDetails(ProductDto productDto) {
		BeanUtils.copyProperties(productDto, product);
		Product updateDetail = productRepository.findById(product.getId()).orElse(null);
		if (updateDetail != null) {
			product.setCategory(productDto.getCategory());
			product.setDescription(productDto.getDescription());
			product.setManufacturer(productDto.getManufacturer());
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setUnit(productDto.getUnit());
			productRepository.save(product);
			return product;
		} 
			throw new ProductException("Unable to update product");
	}

	@Override
	public String deleteProductDetails(ProductDto productDto) {
		BeanUtils.copyProperties(productDto, product);
		Product deleteDetail = productRepository.findById(product.getId()).orElse(null);
		if (deleteDetail != null) {
			productRepository.delete(deleteDetail);
			return null;
		} 
			throw new ProductException("Unable to delete product or Already deleted");
	}
	


}
