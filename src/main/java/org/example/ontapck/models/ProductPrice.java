package org.example.ontapck.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="product_prices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private double discount;
    @Column(name="created_date")
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductPrice(Long id, double price, double discount, LocalDateTime createdDate) {
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", price=" + price +
                ", discount=" + discount +
                ", createdDate=" + createdDate +
                '}';
    }
}
