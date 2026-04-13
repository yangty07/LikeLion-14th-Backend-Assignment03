package com.likelion.likelionassignmentcrud.player.domain;

import com.likelion.likelionassignmentcrud.player.api.dto.request.PlayerUpdateRequestDto;
import com.likelion.likelionassignmentcrud.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long playerId;

    private String gender;

    private String personality;

    private int age;

    private int height;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Player(String gender, String personality, int age, int height, User user) {
        this.gender = gender;
        this.personality = personality;
        this.age = age;
        this.height = height;
        this.user = user;
    }

    public void update(PlayerUpdateRequestDto playerUpdateRequestDto) {
        this.gender = playerUpdateRequestDto.gender();
        this.personality = playerUpdateRequestDto.personality();
        this.age = playerUpdateRequestDto.age();
        this.height = playerUpdateRequestDto.height();
    }
}