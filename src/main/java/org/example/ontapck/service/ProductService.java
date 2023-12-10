package org.example.ontapck.service;

import lombok.AllArgsConstructor;
import org.example.ontapck.models.Product;
import org.example.ontapck.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Page<Product> index(String q, int page, int limit, String sortBy, String sortDirection) {
        Pageable pageable = PageRequest.of(page - 1, limit, Sort.by(Sort.Direction.fromString(sortDirection), sortBy));

        if (q != null && !q.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCase(q, pageable);
        }

        return productRepository.findAll(pageable);
    }
}
