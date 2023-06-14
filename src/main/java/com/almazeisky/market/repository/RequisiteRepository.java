package com.almazeisky.market.repository;

import com.almazeisky.market.model.entity.Requisite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisiteRepository extends JpaRepository<Requisite, Long> {
}
