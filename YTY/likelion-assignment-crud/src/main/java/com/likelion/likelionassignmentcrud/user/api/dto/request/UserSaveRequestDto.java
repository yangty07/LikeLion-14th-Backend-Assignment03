package com.likelion.likelionassignmentcrud.user.api.dto.request;

import com.likelion.likelionassignmentcrud.user.domain.Part;

public record UserSaveRequestDto(
        String name,
        String email,
        Part part
) {
}