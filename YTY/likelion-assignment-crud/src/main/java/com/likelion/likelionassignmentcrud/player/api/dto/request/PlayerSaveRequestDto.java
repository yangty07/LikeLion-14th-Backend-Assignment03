package com.likelion.likelionassignmentcrud.player.api.dto.request;

public record PlayerSaveRequestDto(
        Long userId,
        String gender,
        String personality,
        int age,
        int height
) {
}