package com.cotato.gukbo0th.controller;

import com.cotato.gukbo0th.ResponseDto;
import com.cotato.gukbo0th.dto.CreditRequestDto;
import com.cotato.gukbo0th.dto.FundingsDetailResponseDto;
import com.cotato.gukbo0th.dto.FundingsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fundings")
public class FundingsController {

    private final FundingsService fundingsService;

    @GetMapping("/list")
    public ResponseEntity getList(@RequestParam("email") String email) {
        try {
            FundingsListResponseDto responseDto = fundingsService.getList(email);
            return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "펀딩 리스트 조회 성공", responseDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDto.res(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }

    @GetMapping("/{fundingsId}")
    public ResponseEntity getProduct(@PathVariable("fundingsId") Long id) {
        try {
            FundingsDetailResponseDto responseDto = fundingsService.getDetail(id);
            return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "상세 페이지 조회 성공", responseDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDto.res(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }

    @PostMapping("/credit")
    public ResponseEntity getFunds(@RequestBody CreditRequestDto creditRequestDto) {
        try {
            FundingsDetailResponseDto responseDto = fundingsService.credit(creditRequestDto);
            return ResponseEntity.ok().body(ResponseDto.res(HttpStatus.OK.value(), "펀딩 성공", responseDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDto.res(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
        }
    }
}
