package com.jeremy.CoursJAVA.security;

import com.jeremy.CoursJAVA.model.Role;
import com.jeremy.CoursJAVA.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsCustom implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public UserDetailsCustom (Utilisateur utilisateur) {
        this.userName = utilisateur.getLogin();
        this.password = utilisateur.getPassword();
        this.active = true;

        authorities = new ArrayList<>();

        for (Role role : utilisateur.getListeRole()) {
            authorities.add(new SimpleGrantedAuthority(role.getDenomination()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
