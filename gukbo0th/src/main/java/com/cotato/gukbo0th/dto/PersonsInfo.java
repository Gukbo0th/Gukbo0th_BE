package com.cotato.gukbo0th.dto;

import lombok.Builder;

public class PersonsInfo {
    private String name; // 위인 이름
    private String achieve; // 업적

    @Builder
    public PersonsInfo(String name, String achieve) {
        this.name = name;
        this.achieve = achieve;
    }
}
