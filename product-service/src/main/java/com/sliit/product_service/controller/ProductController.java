package com.sliit.product_service.controller;

import com.sliit.product_service.entity.Product;
import com.sliit.product_service.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // POST - Add product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // GET - All products
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // GET - Product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // DELETE - Product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
