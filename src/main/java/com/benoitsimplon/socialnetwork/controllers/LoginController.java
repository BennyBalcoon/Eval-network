package com.benoitsimplon.socialnetwork.controllers;

import com.benoitsimplon.socialnetwork.dtos.UserDto;
import com.benoitsimplon.socialnetwork.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void verifyUser(@RequestBody UserDto userDto) {
        userService.verifyUser(userDto.getEmail(), userDto.getPassword());
    }
}
