package com.example.roombookingserver.rest;

import com.example.roombookingserver.model.entities.LayoutCapacity;
import com.example.roombookingserver.model.entities.Room;
import com.example.roombookingserver.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RestRoomsController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getRooms(HttpServletResponse response) throws Exception{
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
    public Room updateRoom(@RequestBody Room updatedRoom){
     Room originalRoom = roomRepository.findById(updatedRoom.getId()).get();
     originalRoom.setName(updatedRoom.getName());
     originalRoom.setLocation(updatedRoom.getLocation());
     for(LayoutCapacity lc : updatedRoom.getCapacities()){
         originalRoom.setCapacity(lc);
     }
    // originalRoom.setCapacities(updatedRoom.getCapacities());
        return roomRepository.save(originalRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id){
        roomRepository.deleteById(id);
    }
}
