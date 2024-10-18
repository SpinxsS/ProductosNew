package com.nexsy.util;

import java.util.List;
import java.util.stream.Collectors;

import com.nexsy.dto.ProductDTO;
import com.nexsy.model.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDTO(
            product.getId(),
            product.getTitle(),
            product.getPrice(),
            product.getDescription()
        );
    }

    public static List<ProductDTO> toDTOList(List<Product> products) {
        return products.stream()
                       .map(ProductMapper::toDTO)
                       .collect(Collectors.toList());
    }
}
