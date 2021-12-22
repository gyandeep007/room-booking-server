package com.example.roombookingserver.rest;

import com.example.roombookingserver.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/basicAuth")
public class ValidateUserController {

    @Autowired
    JWTService jwtService;
    @RequestMapping("validate")
    public Map<String,String> userIsValid(){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       User currentUser = (User)authentication.getPrincipal();
       String name = currentUser.getUsername();
       String role = currentUser.getAuthorities().toArray()[0].toString().substring(5);
       String token = jwtService.generateToken(name,role);

        Map<String,String> map = new HashMap<>();
        map.put("result",token);
        return map;
    }
}
