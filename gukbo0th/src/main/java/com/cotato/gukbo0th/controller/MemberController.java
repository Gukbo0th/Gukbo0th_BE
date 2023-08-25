package com.cotato.gukbo0th.controller;

import com.cotato.gukbo0th.ResponseDto;
import com.cotato.gukbo0th.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cotato.gukbo0th.dto.MemberJoinRequest;
import com.cotato.gukbo0th.dto.MemberLoginRequest;
import com.cotato.gukbo0th.dto.MemberLogoutRequest;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseDto<?> join(@RequestBody @Valid MemberJoinRequest memberJoinRequest) {
        memberService.join(memberJoinRequest);
        return ResponseDto.res(201,"회원가입 성공");
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody MemberLoginRequest memberLoginRequest) {
//        String result = memberService.login(memberLoginRequest);
//        return ResponseEntity.ok(result);
//    }
//
//    @PostMapping("/myPage/logout")
//    public ResponseEntity<?> logout(@RequestBody MemberLogoutRequest memberLogoutRequest) {
//        String result = memberService.logout(memberLogoutRequest);
//        return ResponseEntity.ok(result);
//    }
//
//
//    @GetMapping("/list")
//    public ResponseEntity getList(@RequestParam("email") String email) {
//        try {
//            FundingListResponseDto responseDto = fundingsService.getlist(email);
//            return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "펀딩 리스트 조회 성공", responseDto));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(ResponseDto.res(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
//        }
//    }

}
