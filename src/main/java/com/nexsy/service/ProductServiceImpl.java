package com.nexsy.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nexsy.dto.CategoryDTO;
import com.nexsy.dto.ProductDTO;
import com.nexsy.dto.ProductIdResponse;
import com.nexsy.exception.CategoryNotFoundException;
import com.nexsy.exception.InvalidCategoryIdException;
import com.nexsy.exception.ProductAlreadyExistsException;
import com.nexsy.model.Product;
import com.nexsy.repository.ProductRepository;
import com.nexsy.util.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${product.api.url}")
	private String productApiUrl;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryServiceImpl categoryService;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<ProductDTO> getAllProducts() {
		try {
			Product[] products = restTemplate.getForObject(productApiUrl, Product[].class);
			return ProductMapper.toDTOList(Arrays.asList(products));
		} catch (HttpClientErrorException e) {
			throw new RuntimeException("Error fetching products: " + e.getMessage());
		}
	}

	@Override
	public ProductIdResponse createProduct(ProductDTO productDTO) {

		if (productDTO.getCategoryId() == null) {
			throw new InvalidCategoryIdException();
		}

		if (productDTO.getPid() != null) {
			boolean productExists = productRepository.existsById(productDTO.getPid());
			if (productExists) {
				throw new ProductAlreadyExistsException(productDTO.getPid());
			}
		}

		// Obtener todas las categorias
		List<CategoryDTO> categories = categoryService.getAllCategories();

		// Verifica que la categoria deseada exista
		CategoryDTO selectedCategory = categories.stream()
				.filter(category -> category.getId().equals(productDTO.getCategoryId())).findFirst()
				.orElseThrow(() -> new CategoryNotFoundException(productDTO.getCategoryId()));

		// Crear un nuevo producto
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPriceFinal());
		product.setDescription(productDTO.getDescription());
		product.setImageUrl(productDTO.getImageUrl());
		product.setCategoryId(selectedCategory.getId());
		try {
			Product savedProduct = productRepository.save(product);
			return new ProductIdResponse(savedProduct.getId());
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Data integrity violation: " + e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Unexpected error occurred: " + e.getMessage());
		}

	}

}
