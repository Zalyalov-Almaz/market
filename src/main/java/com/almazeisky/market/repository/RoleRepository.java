package com.almazeisky.market.repository;

import com.almazeisky.market.model.entity.Role;
import com.almazeisky.market.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByAuthority(RoleType authority);

}
