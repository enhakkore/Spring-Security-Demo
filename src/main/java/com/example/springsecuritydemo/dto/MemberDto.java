package com.example.springsecuritydemo.dto;

import com.example.springsecuritydemo.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MemberDto {
    private Long id;
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
