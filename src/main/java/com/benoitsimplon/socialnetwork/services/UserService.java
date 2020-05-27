package com.benoitsimplon.socialnetwork.services;

import com.benoitsimplon.socialnetwork.dtos.UserCreateDto;
import com.benoitsimplon.socialnetwork.dtos.UserDto;

import java.util.List;

public interface UserService {

    void create(UserCreateDto dto);

    UserDto getUser(Long id);

    List<UserDto> getAll();
}
