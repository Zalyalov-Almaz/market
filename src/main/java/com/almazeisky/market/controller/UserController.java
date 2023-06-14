package com.almazeisky.market.controller;

import com.almazeisky.market.model.entity.User;
import com.almazeisky.market.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping("users")
    public Page<User> getAll(@RequestParam(name = "offset") Integer offset,
                             @RequestParam(name = "limit") Integer limit) {
        return service.getAll(offset, limit);
    }
}
