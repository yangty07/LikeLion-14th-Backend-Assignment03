package com.likelion.likelionassignmentcrud.player.api.dto.request;

public record PlayerUpdateRequestDto(
        String gender,
        String personality,
        int age,
        int height
) {
}
