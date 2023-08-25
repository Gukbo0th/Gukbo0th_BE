package com.cotato.gukbo0th.controller;

import com.cotato.gukbo0th.ResponseDto;
import com.cotato.gukbo0th.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cotato.gukbo0th.dto.MemberJoinRequest;
import com.cotato.gukbo0th.dto.MemberLoginRequest;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity join(@RequestBody @Valid MemberJoinRequest memberJoinRequest) {
        memberService.join(memberJoinRequest);
        return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.CREATED.value(), "회원가입 성공"));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberLoginRequest memberLoginRequest) {
        if (memberService.login(memberLoginRequest)) {
            return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "로그인 성공", memberLoginRequest.getEmail()));
        } else {
            return ResponseEntity.badRequest().body(ResponseDto.res(HttpStatus.BAD_REQUEST.value(), "로그인 실패"));
        }
    }

    @PostMapping("/myPage/logout")
    public ResponseEntity logout(@RequestBody String email) {
        return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "로그아웃 성공"));
    }
}