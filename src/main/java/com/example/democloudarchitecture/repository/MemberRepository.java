package com.example.democloudarchitecture.repository;

import com.example.democloudarchitecture.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,Long> {
}
