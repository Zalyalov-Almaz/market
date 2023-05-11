package com.almazeisky.market.service.interfaces;

import com.almazeisky.market.model.dto.UserDto;
import com.almazeisky.market.model.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User create(UserDto dto);
    User getById(Long id);

    Page<User> getAll(Integer offset, Integer limit);
    void deleteById(Long id);
}
