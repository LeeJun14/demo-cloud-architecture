package com.example.democloudarchitecture.dto;

import lombok.Getter;

@Getter
public class MemberResponse {

    private final Long id;
    private final String name;
    private final Long age;
    private final String mbti;

    public MemberResponse(Long id, String name, Long age, String mbti) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }

    public static MemberResponse register(Long id, String name, Long age, String mbti) {
        return new MemberResponse(id, name, age, mbti);
    }
}
