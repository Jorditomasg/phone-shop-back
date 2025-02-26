package com.phoneshop.infrastructure.client;

import com.phoneshop.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private com.phoneshop.infrastructure.config.AppConfig appConfig;

    public List<String> getSimilarProductIds(String productId) {
        String url = appConfig.getApiUrl() + "product/" + productId + "/similarids";
        return Arrays.asList(restTemplate.getForObject(url, String[].class));
    }

    public Product getProductById(String productId) {
        String url = appConfig.getApiUrl() + "product/" + productId;
        return restTemplate.getForObject(url, Product.class);
    }

    public List<Product> getAllProducts() {
        String url = appConfig.getApiUrl() + "product/";
        return Arrays.asList(restTemplate.getForObject(url, Product[].class));
    }
}
