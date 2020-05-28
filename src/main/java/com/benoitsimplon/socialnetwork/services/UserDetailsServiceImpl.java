package com.benoitsimplon.socialnetwork.services;

import com.benoitsimplon.socialnetwork.entities.User;
import com.benoitsimplon.socialnetwork.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJpaRepository.findByEmail(username);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
        Set<SimpleGrantedAuthority> collect = new HashSet<>();
        collect.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), collect);
    }
}
