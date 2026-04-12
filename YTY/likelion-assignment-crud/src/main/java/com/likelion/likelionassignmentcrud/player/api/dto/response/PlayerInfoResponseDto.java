package com.likelion.likelionassignmentcrud.player.api.dto.response;

import com.likelion.likelionassignmentcrud.player.domain.Player;
import lombok.Builder;

@Builder
public record PlayerInfoResponseDto(
        String gender,
        String personality,
        int age,
        int height,
        String writer
) {
    public static PlayerInfoResponseDto from(Player player) {
        return PlayerInfoResponseDto.builder()
                .gender(player.getGender())
                .personality(player.getPersonality())
                .age(player.getAge())
                .height(player.getHeight())
                .writer(player.getUser().getName())
                .build();
    }
}