package com.likelion.week.user.domain;

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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "User_id")
    private Long userId;
    private String name;
    private String mail;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Part part;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> characters = new ArrayList<>();

    @Builder
    private User(String name, String mail, Part part) {
        this.name = name;
        this.mail = mail;
        this.part = part;
    }




}
