package com.likelion.likelionassignmentcrud.user.domain.repository;

import com.likelion.likelionassignmentcrud.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}