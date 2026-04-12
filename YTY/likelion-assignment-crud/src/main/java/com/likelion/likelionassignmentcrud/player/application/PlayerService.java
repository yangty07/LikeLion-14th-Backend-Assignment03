package com.likelion.likelionassignmentcrud.player.application;

import com.likelion.likelionassignmentcrud.player.api.dto.request.PlayerSaveRequestDto;
import com.likelion.likelionassignmentcrud.player.api.dto.request.PlayerUpdateRequestDto;
import com.likelion.likelionassignmentcrud.player.api.dto.response.PlayerInfoResponseDto;
import com.likelion.likelionassignmentcrud.player.api.dto.response.PlayerListResponseDto;
import com.likelion.likelionassignmentcrud.player.domain.repository.PlayerRepository;
import com.likelion.likelionassignmentcrud.player.domain.Player;
import com.likelion.likelionassignmentcrud.user.domain.User;
import com.likelion.likelionassignmentcrud.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlayerService {
    private final UserRepository userRepository;
    private final PlayerRepository playerRepository;

    @Transactional
    public void playerSave(PlayerSaveRequestDto playerSaveRequestDto) {
        User user = userRepository.findById(playerSaveRequestDto.userId()).orElseThrow(IllegalArgumentException::new);

        Player player = Player.builder()
                .gender(playerSaveRequestDto.gender())
                .personality(playerSaveRequestDto.personality())
                .age(playerSaveRequestDto.age())
                .height(playerSaveRequestDto.height())
                .user(user)
                .build();

        playerRepository.save(player);
    }

    public PlayerListResponseDto playerFindUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

        List<Player> players = playerRepository.findByUser(user);
        List<PlayerInfoResponseDto> playerInfoResponseDtos = players.stream()
                .map(PlayerInfoResponseDto::from)
                .toList();

        return PlayerListResponseDto.from(playerInfoResponseDtos);
    }

    public void playerDelete(Long playerrId) {
    }


    public void playerUpdate(Long playerId, PlayerUpdateRequestDto playerUpdateRequestDto) {
    }
}
