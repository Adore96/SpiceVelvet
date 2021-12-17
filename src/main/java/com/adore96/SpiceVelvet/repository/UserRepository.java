package com.adore96.SpiceVelvet.repository;

import com.adore96.SpiceVelvet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kasun_k ON 12/17/21
 * @project SpiceVelvet
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
