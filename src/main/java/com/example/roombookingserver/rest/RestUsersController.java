package com.example.roombookingserver.rest;

import com.example.roombookingserver.model.AngularUser;
import com.example.roombookingserver.model.entities.Room;
import com.example.roombookingserver.model.entities.User;
import com.example.roombookingserver.repository.RoomRepository;
import com.example.roombookingserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class RestUsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<AngularUser> getUsers(){
        return userRepository.findAll().parallelStream().map(user -> new AngularUser(user)).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public AngularUser getUserById(@PathVariable("userId") Long id){
        System.out.println("got request for the user id "+id);
        return new AngularUser(userRepository.findById(id).get());
    }

    @PostMapping
    public AngularUser addUser(@RequestBody AngularUser user){
        return new AngularUser(userRepository.save(user.asUser()));
    }

    @PutMapping
    public AngularUser updateUser(@RequestBody AngularUser user){
        return new AngularUser(userRepository.save(user.asUser()));
    }
}
