package com.example.roombookingserver.rest;

import com.example.roombookingserver.model.AngularUser;
import com.example.roombookingserver.model.entities.Room;
import com.example.roombookingserver.model.entities.User;
import com.example.roombookingserver.repository.RoomRepository;
import com.example.roombookingserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class RestUsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<AngularUser> getUsers()  {
        return userRepository.findAll().parallelStream().map(user -> new AngularUser(user)).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public AngularUser getUserById(@PathVariable("userId") Long id){
        System.out.println("got request for the user id "+id);
        return new AngularUser(userRepository.findById(id).get());
    }

    @PostMapping
    public AngularUser addUser(@RequestBody User user){
        return new AngularUser(userRepository.save(user));
    }

    @PutMapping
    public AngularUser updateUser(@RequestBody AngularUser user, HttpServletRequest request){
        System.out.println("request received "+request);
        return new AngularUser(userRepository.save(user.asUser()));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/resetPassword/{id}")
    public void resetPassword(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        user.setPassword("secret");
        userRepository.save(user);
    }
}
