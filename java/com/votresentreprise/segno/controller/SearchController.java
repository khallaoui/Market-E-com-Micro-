package com.votresentreprise.segno.controller;

import com.votresentreprise.segno.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String q) {
        // Implémentation simplifiée
        return List.of(
            new Product("prod_123", "Ordinateur Dell XPS", "électronique", 1299.99, 4.5),
            new Product("prod_456", "Smartphone iPhone 15", "électronique", 999.99, 4.7)
        );
    }
}