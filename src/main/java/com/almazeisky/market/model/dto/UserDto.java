package com.almazeisky.market.model.dto;

import lombok.Builder;

@Builder
public record UserDto(String username,
                      String password,
                      String matchingPassword,
                      String email) {
}
