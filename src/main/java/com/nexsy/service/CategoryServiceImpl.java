package com.nexsy.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nexsy.dto.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${category.api.url}")
    private String categoryApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CategoryDTO> getAllCategories() {
        try {
            // Imprimir la URL para verificar que es correcta
            System.out.println("Calling API: " + categoryApiUrl);
            ResponseEntity<CategoryDTO[]> response = restTemplate.getForEntity(categoryApiUrl, CategoryDTO[].class);
            // Verifica el estado de la respuesta
            if (response.getStatusCode().is2xxSuccessful()) {
                return Arrays.asList(response.getBody());
            } else {
                throw new RuntimeException("Error fetching categories: " + response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Error fetching categories: " + e.getMessage());
        }
    }
	

}
