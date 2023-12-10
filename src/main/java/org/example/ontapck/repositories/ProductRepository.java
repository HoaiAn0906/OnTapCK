package org.example.ontapck.repositories;

import org.example.ontapck.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(String q, org.springframework.data.domain.Pageable pageable);
}
