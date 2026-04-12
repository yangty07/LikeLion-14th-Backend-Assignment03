package com.likelion.likelionassignmentcrud.user.application;

import com.likelion.likelionassignmentcrud.user.api.dto.request.UserSaveRequestDto;
import com.likelion.likelionassignmentcrud.user.api.dto.request.UserUpdateRequestDto;
import com.likelion.likelionassignmentcrud.user.api.dto.response.UserInfoResponseDto;
import com.likelion.likelionassignmentcrud.user.api.dto.response.UserListResponseDto;
import com.likelion.likelionassignmentcrud.user.domain.User;
import com.likelion.likelionassignmentcrud.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void userSave(UserSaveRequestDto userSaveRequestDto) {
        User user = User.builder()
                .name(userSaveRequestDto.name())
                .email(userSaveRequestDto.email())
                .part(userSaveRequestDto.part())
                .build();
        userRepository.save(user);
    }

    public UserInfoResponseDto userFindOne(Long userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(IllegalArgumentException::new);
        return UserInfoResponseDto.from(user);
    }


    public UserListResponseDto userFindAll() {

        List<User> users = userRepository.findAll();
        List<UserInfoResponseDto> userInfoResponseDtoList = users.stream()
                .map(UserInfoResponseDto::from)
                .toList();
        return UserListResponseDto.from(userInfoResponseDtoList);
    }


    public void userUpdate(Long userId, UserUpdateRequestDto userUpdateRequestDto) {
    }

    public void userDelete(Long userId) {

    }
}