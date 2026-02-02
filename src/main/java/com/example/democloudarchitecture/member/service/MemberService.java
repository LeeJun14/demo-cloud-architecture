package com.example.democloudarchitecture.member.service;

import com.example.democloudarchitecture.member.dto.PostMemberRequest;
import com.example.democloudarchitecture.member.dto.MemberResponse;
import com.example.democloudarchitecture.member.entity.Member;
import com.example.democloudarchitecture.member.repository.MemberRepository;
import com.example.democloudarchitecture.s3.service.S3Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final S3Service s3Service;

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

    @Transactional
    public void uploadProfileImage(Long id, MultipartFile file) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id " + id));

        String key = s3Service.upload(file, id);  // S3Service 호출
        member.updateProfileImageKey(key);
    }

    @Transactional(readOnly = true)
    public String getProfileImageUrl(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id " + id));

        if (member.getProfileImageKey() == null) {
            throw new IllegalArgumentException("Profile image not found");
        }

        return s3Service.getDownloadUrl(member.getProfileImageKey()).toString();  // S3Service 호출
    }
}
