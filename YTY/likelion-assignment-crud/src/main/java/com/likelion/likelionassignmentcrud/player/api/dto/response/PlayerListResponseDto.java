package com.likelion.likelionassignmentcrud.player.api.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record PlayerListResponseDto(
        List<PlayerInfoResponseDto> players
) {
    public static PlayerListResponseDto from(List<PlayerInfoResponseDto> players) {
        return PlayerListResponseDto.builder()
                .players(players)
                .build();
    }
}