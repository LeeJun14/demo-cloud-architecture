package com.example.democloudarchitecture.member.repository;

import com.example.democloudarchitecture.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,Long> {
}
