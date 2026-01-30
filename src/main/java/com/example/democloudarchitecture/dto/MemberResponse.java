package com.example.democloudarchitecture.dto;

import lombok.Getter;

@Getter
public class PostMemberResponse {

    private final Long id;
    private final String name;
    private final Long age;
    private final String mbti;

    public PostMemberResponse(Long id, String name, Long age, String mbti) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    public static PostMemberResponse register(Long id, String name, Long age, String mbti) {
        return new PostMemberResponse(id, name, age, mbti);
    }
}
