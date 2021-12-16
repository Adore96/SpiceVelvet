package com.adore96.SpiceVelvet.service.user;

import com.adore96.SpiceVelvet.model.User;
import com.adore96.SpiceVelvet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author kasun_k ON 12/16/21
 * @project SpiceVelvet
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository studentRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = studentRepo.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return users.map(UserPrincipal::new).get();
    }
