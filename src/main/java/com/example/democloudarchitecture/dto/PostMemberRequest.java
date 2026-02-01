package com.example.democloudarchitecture.dto;

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
