package com.likelion.likelionassignmentcrud.user.api.dto.request;

import com.likelion.likelionassignmentcrud.user.domain.Part;

public record UserUpdateRequestDto(
        String name,
        String email,
        Part part
) {
}
