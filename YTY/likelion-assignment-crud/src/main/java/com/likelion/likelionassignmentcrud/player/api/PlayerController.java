package com.likelion.likelionassignmentcrud.player.api;

import com.likelion.likelionassignmentcrud.player.api.dto.request.PlayerSaveRequestDto;
import com.likelion.likelionassignmentcrud.player.api.dto.request.PlayerUpdateRequestDto;
import com.likelion.likelionassignmentcrud.player.api.dto.response.PlayerListResponseDto;
import com.likelion.likelionassignmentcrud.player.application.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
@Tag(name = "PLAYER API", description = "캐릭터 수정하는 api ")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping()
    @Operation(summary = "캐릭터 생성", description = "캐릭터를 생성했습니다. 예쁘게 꾸며주세요!")
    public ResponseEntity<String> playerSave(@RequestBody PlayerSaveRequestDto playerSaveRequestDto) {
        playerService.playerSave(playerSaveRequestDto);
        return new ResponseEntity<>("용사님, 환영합니다! 마왕을 무찔러 주세요!", HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "캐릭터 userId로 조회", description = "캐릭터 userId로 조회")
    public ResponseEntity<PlayerListResponseDto> myplayerFindAll(@PathVariable("userId") Long userId) {
        PlayerListResponseDto playerListResponseDto = playerService.playerFindUser(userId);
        return new ResponseEntity<>(playerListResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{playerId}")
    @Operation(summary = "캐릭터 Id로 수정", description = "캐릭터 이름, 특징, 나이, 키 수정")
    public ResponseEntity<String> playerUpdate(@PathVariable("playerId") Long playerId,
                                             @RequestBody PlayerUpdateRequestDto playerUpdateRequestDto) {
        playerService.playerUpdate(playerId, playerUpdateRequestDto);
        return new ResponseEntity<>("캐릭터를 수정했습니다! 또 바꾸면 캐릭터가 속삭해 해요ㅠㅠ", HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}")
    @Operation(summary = "캐릭터 삭제", description = "캐릭터 Id로 삭제")
    public ResponseEntity<String> playerDelete(@PathVariable("playerId") Long playerId) {
        playerService.playerDelete(playerId);
        return new ResponseEntity<>("캐릭터가 비명을 지르며 영원한 죽음을 맞이했습니다.", HttpStatus.OK);
    }

}
