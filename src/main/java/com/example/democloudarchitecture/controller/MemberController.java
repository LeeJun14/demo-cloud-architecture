package com.example.democloudarchitecture.controller;

import com.example.democloudarchitecture.dto.PostMemberRequest;
import com.example.democloudarchitecture.dto.MemberResponse;
import com.example.democloudarchitecture.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity<MemberResponse> create(@RequestBody PostMemberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findOne(id));
    }
}
