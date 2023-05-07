package com.almazeisky.market.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "buckets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bucket {

    private static final String SEQUENCE = "bucket_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
    @SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE, allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name = "buckets_products",
               joinColumns = @JoinColumn(name = "bucket_id"),
               inverseJoinColumns = @JoinColumn(name = "bucket_detail_id"))
    private List<BucketDetail> bucketDetails;
}
