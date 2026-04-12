package com.likelion.likelionassignmentcrud.user.api;

import com.likelion.likelionassignmentcrud.user.api.dto.request.UserSaveRequestDto;
import com.likelion.likelionassignmentcrud.user.api.dto.request.UserUpdateRequestDto;
import com.likelion.likelionassignmentcrud.user.api.dto.response.UserInfoResponseDto;
import com.likelion.likelionassignmentcrud.user.api.dto.response.UserListResponseDto;
import com.likelion.likelionassignmentcrud.user.application.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "유저 API", description = "유저 관리하는 api ")
public class UserController {

    private final UserService userService;

    @PostMapping()
    @Operation(summary = "유저 회원가입", description = "유저 회원가입 설명란입니다.")
    public ResponseEntity<String> userSave(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        userService.userSave(userSaveRequestDto);
        return new ResponseEntity<>("회원가입 완료! 국가 대전쟁에 환영합니다.", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @Operation(summary = "유저 전체조회", description = "유저 전체조회")
    public ResponseEntity<UserListResponseDto> userFindAll() {
        UserListResponseDto userListResponseDto = userService.userFindAll();
        return new ResponseEntity<>(userListResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "유저 1명 조회", description = "유저 id로 멤버조회")
    public ResponseEntity<UserInfoResponseDto> userFindOne(@PathVariable("userId") Long userId) {
        UserInfoResponseDto userInfoResponseDto = userService.userFindOne(userId);
        return new ResponseEntity<>(userInfoResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    @Operation(summary = "유저 정보 업데이트", description = "유저 정보 업데이트")
    public ResponseEntity<String> userUpdate(@PathVariable("userId") Long userId,
                                               @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        userService.userUpdate(userId, userUpdateRequestDto);
        return new ResponseEntity<>("유저 수정", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "유저 삭제", description = "유저 삭제")
    public ResponseEntity<String> userDelete(@PathVariable("userId") Long userId) {
        userService.userDelete(userId);
        return new ResponseEntity<>("그동안 저희 게임을 이용해 주셔서 감사합니다.", HttpStatus.OK);
    }
}