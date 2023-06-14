package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.RoleRepository;
import com.almazeisky.market.service.interfaces.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

}
