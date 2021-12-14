package com.example.roombookingserver.repository;

import com.example.roombookingserver.model.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
