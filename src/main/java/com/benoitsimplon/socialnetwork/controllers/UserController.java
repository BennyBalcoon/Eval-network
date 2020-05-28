package com.benoitsimplon.socialnetwork.controllers;

import com.benoitsimplon.socialnetwork.dtos.UserCreateDto;
import com.benoitsimplon.socialnetwork.dtos.UserDto;
import com.benoitsimplon.socialnetwork.entities.User;
import com.benoitsimplon.socialnetwork.services.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable("id") Long id) {
        return service.getUser(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid UserCreateDto dto) {
        service.create(dto);
    }


}
