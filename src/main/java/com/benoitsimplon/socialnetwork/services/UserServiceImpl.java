package com.benoitsimplon.socialnetwork.services;

import com.benoitsimplon.socialnetwork.dtos.UserCreateDto;
import com.benoitsimplon.socialnetwork.dtos.UserDto;
import com.benoitsimplon.socialnetwork.entities.User;
import com.benoitsimplon.socialnetwork.repositories.UserJpaRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserJpaRepository userRepository;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserJpaRepository userRepository, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void create(UserCreateDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setBirthdate(dto.getBirthdate());
        userRepository.save(user);
    }

    public UserDto getUser(Long id) {
        User user = userRepository.getOne(id);
        return convertFrom(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user :
                users) {
            UserDto dto = convertFrom(user);
            userDtos.add(dto);
        }
        return userDtos;
    }

    private UserDto convertFrom(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    @Transactional
    public void verifyUser(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Bad credentials" + email);
        }
    }

}
