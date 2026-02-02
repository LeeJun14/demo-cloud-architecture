package com.example.democloudarchitecture.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long age;

    @Column(nullable = false, length = 4)
    private String mbti;

    // 추가: 프로필 이미지 S3 Key
    @Column(length = 500)
    private String profileImageKey;

    public static Member register(String name, Long age, String mbti) {
        Member member = new Member();
        member.name = name;
        member.age = age;
        member.mbti = mbti;
        return member;
    }

    // 추가: 프로필 이미지 업데이트
    public void updateProfileImageKey(String profileImageKey) {
        this.profileImageKey = profileImageKey;
    }
}
