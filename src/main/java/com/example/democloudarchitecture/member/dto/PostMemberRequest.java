package com.example.democloudarchitecture.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PostMemberRequest {
    @NotBlank
    private String name;
    @NotBlank
    private Long age;
    @NotBlank
    private String mbti;
}
