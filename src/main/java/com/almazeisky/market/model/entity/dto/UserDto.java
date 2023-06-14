package com.almazeisky.market.model.entity.dto;

import lombok.Builder;

@Builder
public record UserDto(String username,
                      String password,
                      String matchingPassword,
                      String email) {
}
