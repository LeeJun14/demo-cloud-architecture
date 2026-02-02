package com.example.democloudarchitecture.member.controller;

import com.example.democloudarchitecture.member.dto.PostMemberRequest;
import com.example.democloudarchitecture.member.dto.MemberResponse;
import com.example.democloudarchitecture.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;  // 하나만!

    @PostMapping()
    public ResponseEntity<MemberResponse> create(@RequestBody PostMemberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findOne(id));
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<Map<String, String>> uploadProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {

        memberService.uploadProfileImage(id, file);  // 위임만

        return ResponseEntity.ok(Map.of("message", "Profile image uploaded successfully"));
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<Map<String, String>> getProfileImageUrl(@PathVariable Long id) {
        String presignedUrl = memberService.getProfileImageUrl(id);  // 위임만

        return ResponseEntity.ok(Map.of("url", presignedUrl));
    }
}
