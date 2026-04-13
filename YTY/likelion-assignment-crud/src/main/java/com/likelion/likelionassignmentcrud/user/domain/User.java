package com.likelion.likelionassignmentcrud.user.domain;

import com.likelion.likelionassignmentcrud.player.domain.Player;
import com.likelion.likelionassignmentcrud.user.api.dto.request.UserUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Part part;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players = new ArrayList<>();

    @Builder
    private User(String name, String email, Part part) {
        this.name = name;
        this.email = email;
        this.part = part;
    }

    public void update(UserUpdateRequestDto userUpdateRequestDto) {
        this.name = userUpdateRequestDto.name();
        this.email = userUpdateRequestDto.email();
        this.part = userUpdateRequestDto.part();
    }
}