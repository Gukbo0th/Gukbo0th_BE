package com.cotato.gukbo0th.controller;

import com.cotato.gukbo0th.ResponseDto;
import com.cotato.gukbo0th.dto.MyPageResponseDto;
import com.cotato.gukbo0th.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members/myPage")
public class MypageController {

    private final MypageService mypageService;

    @GetMapping("")
    public ResponseEntity getMemberInfo(@RequestParam("email") String email) {
        MyPageResponseDto responseDto = mypageService.getMemberInfo(email);
        return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "마이페이지 조회 성공", responseDto));
    }

}
