package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dto.MemberDto;
import com.example.springsecuritydemo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/signUp")
    public String getSignUp() {
        return "signUp";
    }

    @PostMapping("/user/signUp")
    public String postSignUp(MemberDto memberDto){
        memberService.joinUser(memberDto);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user/login/result")
    public String loginSuccess() {
        return "loginSuccess";
    }

    @GetMapping("/user/logout/result")
    public String logoutSuccess() {
        return "logout";
    }

    @GetMapping("/user/denied")
    public String denied() {
        return "denied";
    }

    @GetMapping("/user/myInfo")
    public String myInfo() {
        return "myInfo";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
