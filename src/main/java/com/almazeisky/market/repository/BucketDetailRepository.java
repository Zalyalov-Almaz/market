package com.almazeisky.market.repository;

import com.almazeisky.market.model.entity.BucketDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketDetailRepository extends JpaRepository<BucketDetail, Long> {
}
