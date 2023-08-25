package com.cotato.gukbo0th.dto;

import lombok.Getter;

@Getter
public class CreditRequestDto {
    private String email; // 사용자 이메일
    private Long fundings_id; // 펀딩ID
    private Long quantity; // 구매한 개수
    private String person; // 선택한 위인 이름
}
