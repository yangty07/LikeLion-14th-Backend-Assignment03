package com.likelion.likelionassignmentcrud.player.domain.repository;

import com.likelion.likelionassignmentcrud.user.domain.User;
import com.likelion.likelionassignmentcrud.player.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByUser(User user);
}