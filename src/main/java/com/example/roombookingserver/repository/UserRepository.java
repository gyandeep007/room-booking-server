package com.example.roombookingserver.repository;

import com.example.roombookingserver.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
