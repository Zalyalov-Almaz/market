package com.almazeisky.market.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private static final String SEQUENCE = "product_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    private Long id;
    private String title;
    private BigDecimal price;
    @ManyToMany
    @JoinTable(name = "products_categories",
               joinColumns = @JoinColumn (name = "product_id"),
               inverseJoinColumns = @JoinColumn (name = "category_id"))
    private List<ProductCategory> category;

}
