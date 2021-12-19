package com.example.roombookingserver.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basicAuth")
public class ValidateUserController {

    @RequestMapping("validate")
    public String userIsValid(){
        return "{\"result\":\"Ok\"}";
    }
}
