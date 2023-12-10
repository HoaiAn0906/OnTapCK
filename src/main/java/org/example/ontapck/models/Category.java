package org.example.ontapck.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;

    @ManyToOne
    @JoinColumn(name = "parent_id") // Tạo cột parent_id trong database
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> childCategories;

    public Category(Long id, String name) {
    }
}
