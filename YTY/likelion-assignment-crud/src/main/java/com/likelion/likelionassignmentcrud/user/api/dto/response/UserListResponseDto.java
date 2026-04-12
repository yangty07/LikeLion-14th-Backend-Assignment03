package com.likelion.likelionassignmentcrud.user.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record UserListResponseDto(
        List<UserInfoResponseDto> users
) {
    public static UserListResponseDto from(
            List<UserInfoResponseDto> users) {
        return UserListResponseDto.builder()
                .users(users)
                .build();
    }
}