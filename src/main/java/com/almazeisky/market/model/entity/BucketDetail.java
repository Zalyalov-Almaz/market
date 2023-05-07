package com.almazeisky.market.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bucket_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BucketDetail {

    private static final String SEQUENCE = "bucket_details_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private BigDecimal price;
    private BigDecimal amount;
    private BigDecimal sum;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "bucket_id")
    private Bucket bucket;

}
