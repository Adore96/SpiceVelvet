package com.adore96.SpiceVelvet.service.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author kasun_k ON 12/16/21
 * @project SpiceVelvet
 */

public class UserPrincipal implements UserDetails {

    private final Users users;

    public UserPrincipal(Users users) {
        super();
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        return authorities;
    }

    @Override
    public String getPassword() {
        System.out.println("UserPrincipal Getpassword method --> " + users.getPassword());
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("UserPrincipal Getusername method --> " + users.getUsername());
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

