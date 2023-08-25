package com.cotato.gukbo0th.service;

import com.cotato.gukbo0th.domain.*;
import com.cotato.gukbo0th.dto.CreditRequestDto;
import com.cotato.gukbo0th.dto.FundingsDetailResponseDto;
import com.cotato.gukbo0th.dto.FundingsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FundingsService {

    private final MembersRepository membersRepository;
    private final FundingsRepository fundingsRepository;
    public List<FundingsListResponseDto> getList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Fundings> fundings = fundingsRepository.findAll(sort);
        List<FundingsListResponseDto> responseFundings = new ArrayList<>();

        for(Fundings f : fundings) {
            responseFundings.add(FundingsListResponseDto.builder().fundings(f).build());
        }

        return responseFundings;
    }

//    public FundingsDetailResponseDto getDetail(Long id) {
//    }
//
//    public FundingsDetailResponseDto credit(CreditRequestDto creditRequestDto) {
//    }
}
