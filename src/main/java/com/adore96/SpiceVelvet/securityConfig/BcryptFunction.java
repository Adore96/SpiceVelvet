package com.adore96.SpiceVelvet.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author kasun_k ON 12/16/21
 * @project SpiceVelvet
 */

@Service
public class BcryptFunction {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
