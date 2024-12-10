package com.studentmanagementsystem.student_management_system.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
public class UsersPrincipal implements UserDetails {
    private Users users;

    public UsersPrincipal(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (this.users != null && this.users.getRole() != null) {
            String role = this.users.getRole().toUpperCase();
            switch (role) {
                case "ADMIN":
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    break;
                case "STUDENT":
                    authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
                    break;
                default:
                    System.out.println("Unknown role: " + role);
                    break;
            }
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
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
