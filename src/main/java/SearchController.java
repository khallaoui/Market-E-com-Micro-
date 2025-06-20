import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SearchController {

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchProducts(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double min_price,
            @RequestParam(required = false) Double max_price,
            @RequestParam(required = false) String sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit) {

        // Logique de recherche (simulée)
        List<Product> products = List.of(
            new Product("prod_123", "Ordinateur Dell XPS", "électronique", 1299.99, 4.5),
            new Product("prod_456", "Smartphone iPhone 15", "électronique", 999.99, 4.7)
        );

        // Filtrage (exemple simplifié)
        List<Product> filtered = products.stream()
            .filter(p -> q == null || p.getName().toLowerCase().contains(q.toLowerCase()))
            .collect(Collectors.toList());

        // Pagination (exemple)
        int totalItems = filtered.size();
        int totalPages = (int) Math.ceil((double) totalItems / limit);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", filtered);
        response.put("pagination", Map.of(
            "total_items", totalItems,
            "total_pages", totalPages,
            "current_page", page,
            "limit", limit
        ));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/categories")
    public ResponseEntity<Map<String, Object>> getCategories() {
        List<String> categories = List.of("électronique", "vêtements", "livres");
        return ResponseEntity.ok(Map.of("success", true, "data", categories));
    }
}