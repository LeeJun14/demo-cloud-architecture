package com.example.democloudarchitecture.service;

import com.example.democloudarchitecture.dto.PostMemberRequest;
import com.example.democloudarchitecture.dto.MemberResponse;
import com.example.democloudarchitecture.entity.Member;
import com.example.democloudarchitecture.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse save(@Valid PostMemberRequest request) {
        Member member = Member.register(
                request.getName(),
                request.getAge(),
                request.getMbti()
        );
        Member savedMember = memberRepository.save(member);

        return MemberResponse.register(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getAge(),
                savedMember.getMbti()
        );
    }

    @Transactional(readOnly = true)
    public MemberResponse findOne(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member not found with id " + id)
        );

        return MemberResponse.register(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti()
        );
    }
}
