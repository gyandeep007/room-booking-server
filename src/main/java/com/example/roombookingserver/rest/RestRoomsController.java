package com.example.roombookingserver.rest;

import com.example.roombookingserver.model.entities.Room;
import com.example.roombookingserver.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RestRoomsController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getRooms(){
           return roomRepository.findAll();
    }

    @GetMapping("/{roomId}")
    public Room getRoomById(@PathVariable("roomId") Long id){
        return roomRepository.findById(id).get();
    }

    @PostMapping()
    public Room addRoom(@RequestBody Room room){
        return roomRepository.save(room);
    }

    @PutMapping()
    public Room updateRoom(@RequestBody Room room){

        return roomRepository.save(room);
    }

}
