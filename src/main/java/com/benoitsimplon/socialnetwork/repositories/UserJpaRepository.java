package com.benoitsimplon.socialnetwork.repositories;

import com.benoitsimplon.socialnetwork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
