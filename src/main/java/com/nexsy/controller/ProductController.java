package com.nexsy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexsy.dto.ProductDTO;
import com.nexsy.dto.ProductIdResponse;
import com.nexsy.service.ProductService;

@RestController
@RequestMapping("/nexsys/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductIdResponse> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        // Verificar que se haya pasado un ID de categoría valido
        if (productDTO.getCategoryId() == null) {
            throw new RuntimeException("Category ID is required");
        }

        ProductIdResponse createdProduct = productService.createProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }


}
