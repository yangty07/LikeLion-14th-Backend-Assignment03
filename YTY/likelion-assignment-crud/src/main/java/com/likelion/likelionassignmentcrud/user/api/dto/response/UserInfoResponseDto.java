package com.likelion.likelionassignmentcrud.user.api.dto.response;

import com.likelion.likelionassignmentcrud.user.domain.User;
import com.likelion.likelionassignmentcrud.user.domain.Part;
import lombok.Builder;

@Builder
public record UserInfoResponseDto(
        String name,
        String email,
        Part part
) {
    public static UserInfoResponseDto from(User user) {
        return UserInfoResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .part(user.getPart())
                .build();
    }
}