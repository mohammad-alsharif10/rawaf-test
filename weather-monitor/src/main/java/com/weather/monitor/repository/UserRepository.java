package com.weather.monitor.repository;

import com.weather.monitor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author mohammad
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * @param email
     * findByEmail to check if user there findByEmail to check if user there
     * @return Optional<User>
     */
    Optional<User> findByEmail(String email);

}
