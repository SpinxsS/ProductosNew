package com.nexsy.service;

import java.util.List;

import com.nexsy.dto.ProductDTO;
import com.nexsy.dto.ProductIdResponse;

public interface ProductService {
	
	List<ProductDTO> getAllProducts();

	ProductIdResponse createProduct(ProductDTO productDTO);
}
