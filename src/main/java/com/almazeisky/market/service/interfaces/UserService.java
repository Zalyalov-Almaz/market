package com.almazeisky.market.service.interfaces;

import com.almazeisky.market.model.entity.dto.UserDto;
import com.almazeisky.market.model.entity.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {

    User create(UserDto dto);
    User getById(UUID id);
    User update(User user);
    Page<User> getAll(Integer offset, Integer limit);
    void deleteById(UUID id);
}
