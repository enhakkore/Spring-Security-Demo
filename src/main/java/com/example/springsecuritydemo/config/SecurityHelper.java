package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.domain.Role;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class SecurityHelper {

    private Collection<? extends GrantedAuthority> authorities = Collections.emptyList();

    private Authentication authentication;

    public SecurityHelper(SecurityContext context){
        authentication = context.getAuthentication();
        if(Objects.nonNull(authentication))
            authorities = authentication.getAuthorities();
    }

    public boolean isAuthenticated() {
        return Objects.nonNull(authentication) ? authentication.isAuthenticated() : false;
    }

    public boolean isAnonymous() {
        return Objects.nonNull(authentication) ? authentication instanceof AnonymousAuthenticationToken : true;
    }

    public String userEmail() {
        return Objects.nonNull(authentication) ? authentication.getName() : "";
    }

    public boolean isAdmin() {
        return authorities.stream().anyMatch(role -> role.getAuthority().equals(Role.ADMIN.getValue()));
    }

    public boolean isMember() {
        return authorities.stream().anyMatch(role -> role.getAuthority().equals(Role.MEMBER.getValue()));
    }
}
