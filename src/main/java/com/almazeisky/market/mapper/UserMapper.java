package com.almazeisky.market.mapper;

import com.almazeisky.market.model.dto.UserDto;
import com.almazeisky.market.model.entity.Requisite;
import com.almazeisky.market.model.entity.Role;
import com.almazeisky.market.model.entity.User;
import com.almazeisky.market.model.enums.RoleType;
import com.almazeisky.market.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RoleRepository roleRepository;

    public User toEntity(UserDto dto) {
        Requisite requisite = Requisite.builder()
                .email(dto.email())
                .build();
        List<Requisite> requisites = new ArrayList<>();
        requisites.add(requisite);
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.getRoleByAuthority(RoleType.USER );
        roles.add(role);
        User user = User.builder()
                .username(dto.username())
                .requisites(requisites)
                .roles(roles)
                .build();
        return user;
    }
}
