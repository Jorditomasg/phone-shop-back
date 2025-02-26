package com.phoneshop.infrastructure.controller;

import com.phoneshop.application.port.dto.ProductDTO;
import com.phoneshop.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}/similar")
    public List<ProductDTO> getSimilarProducts(@PathVariable String id) {
        return productService.getSimilarProducts(id);
    }

    @GetMapping({"", "/"})
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}
