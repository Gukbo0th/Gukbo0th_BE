package com.cotato.gukbo0th.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum State { // 펀딩 상태

    ON("ROLE_ON", "펀딩 진행 중"),
    OFF("ROLE_OFF", "펀딩 종료");

    private final String key;
    private final String title;
}
