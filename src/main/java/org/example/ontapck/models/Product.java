package org.example.ontapck.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductPrice> productPrices;

    @Override
    public String toString() {
        Category category1 = new Category();
        category1.setId(this.category.getId());
        category1.setName(this.category.getName());
        Set<ProductPrice> productPrices1 = new HashSet<>();
        for (ProductPrice productPrice : this.productPrices) {
            ProductPrice productPrice1 = new ProductPrice();
            productPrice1.setId(productPrice.getId());
            productPrice1.setPrice(productPrice.getPrice());
            productPrice1.setDiscount(productPrice.getDiscount());
            productPrice1.setCreatedDate(productPrice.getCreatedDate());
            productPrices1.add(productPrice1);
        }

        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category1 +
                ", productPrices=" + productPrices1 +
                '}';
    }
}
