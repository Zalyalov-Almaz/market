package com.almazeisky.market.controller;

import com.almazeisky.market.model.entity.dto.UserDto;
import com.almazeisky.market.model.entity.User;
import com.almazeisky.market.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/manager")
@RequiredArgsConstructor
public class ManagerController {

    private final UserService service;

    @PostMapping
    public User createUser(@RequestBody UserDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
