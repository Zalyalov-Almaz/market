package com.almazeisky.market.controller;

import com.almazeisky.market.model.dto.UserDto;
import com.almazeisky.market.model.entity.User;
import com.almazeisky.market.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User createUser(@RequestBody UserDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public Page<User> getAll(@RequestParam(name = "offset") Integer offset,
                             @RequestParam(name = "limit") Integer limit) {
        return service.getAll(offset, limit);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
