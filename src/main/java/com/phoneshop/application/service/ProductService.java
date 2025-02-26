package com.phoneshop.application.service;

import com.phoneshop.application.port.dto.ProductDTO;
import com.phoneshop.application.port.mapper.ProductMapper;
import com.phoneshop.domain.model.Product;
import com.phoneshop.infrastructure.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductClient productClient;

    public List<ProductDTO> getSimilarProducts(String productId) {
        List<String> similarIds = productClient.getSimilarProductIds(productId);

        return similarIds.stream()
                .map(productClient::getProductById)
                .filter(Objects::nonNull)
                .map(ProductMapper::toDTO)
                .toList();
    }

    public List<ProductDTO> getAllProducts() {
        return productClient.getAllProducts().stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    public ProductDTO getProductById(String productId) {
        Product product = productClient.getProductById(productId);
        return product != null ? ProductMapper.toDTO(product) : null;
    }
}
