package com.example.democloudarchitecture.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private Long age;

    @NotBlank
    @Column(nullable = false)
    private String mbti;

    public static Member register(String name, Long age, String mbti) {
        Member member = new Member();
        member.name = name;
        member.age = age;
        member.mbti = mbti;

        return member;
    }
}
