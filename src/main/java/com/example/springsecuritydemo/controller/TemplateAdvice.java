package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.config.SecurityHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class TemplateAdvice {
    private SecurityHelper securityHelper;

    @ModelAttribute
    public void addDefaultAttribute(Model model) {
        securityHelper = new SecurityHelper(SecurityContextHolder.getContext());

        model.addAttribute("isLoggedIn", securityHelper.isAuthenticated() && !securityHelper.isAnonymous());
        model.addAttribute("userEmail", securityHelper.userEmail());
        model.addAttribute("isAdmin", securityHelper.isAdmin());
        model.addAttribute("isMember", securityHelper.isMember());
    }
}
