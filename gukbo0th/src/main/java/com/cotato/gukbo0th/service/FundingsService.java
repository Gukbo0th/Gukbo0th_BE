package com.cotato.gukbo0th.service;

import com.cotato.gukbo0th.domain.*;
import com.cotato.gukbo0th.dto.CreditRequestDto;
import com.cotato.gukbo0th.dto.FundingsDetailResponseDto;
import com.cotato.gukbo0th.dto.FundingsListResponseDto;
import com.cotato.gukbo0th.dto.PersonsInfo;
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
    private final PersonsRepository personsRepository;
    public List<FundingsListResponseDto> getList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        List<Fundings> fundings = fundingsRepository.findAll(sort);
        List<FundingsListResponseDto> responseFundings = new ArrayList<>();

        for(Fundings f : fundings) {
            responseFundings.add(FundingsListResponseDto.builder().fundings(f).build());
        }

        return responseFundings;
    }

    public FundingsDetailResponseDto getDetail(Long id) throws Exception {
        try {
            Fundings fundings = fundingsRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 펀딩 고유 번호"));
            List<Persons> persons = personsRepository.findByFundings(fundings);
            List<PersonsInfo> personsInfoList = new ArrayList<>();
            for(Persons p : persons) {
                personsInfoList.add(PersonsInfo.builder()
                        .name(p.getName())
                        .achieve(p.getAchieve())
                        .build());
            }
            return new FundingsDetailResponseDto(fundings,personsInfoList);
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public FundingsDetailResponseDto credit(CreditRequestDto creditRequestDto) throws Exception{
        Fundings fundings = fundingsRepository.findById(creditRequestDto.getFundings_id())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 펀딩 고유 번호"));

        Members members = membersRepository.findByEmail(creditRequestDto.getEmail());

        if(creditRequestDto.getQuantity() > fundings.getRemain()) {
            throw new Exception("최대" + fundings.getRemain() + "개 구매 가능");
        }

        fundings.updateRemain(creditRequestDto.getQuantity());
        Purchases purchases = Purchases.builder()
                .person(creditRequestDto.getPerson())
                .amount(fundings.getProdAmount() * creditRequestDto.getQuantity())
                .quantity(creditRequestDto.getQuantity())
                .members(members)
                .fundings(fundings)
                .build();

        List<Persons> persons = personsRepository.findByFundings(fundings);
        List<PersonsInfo> personsInfoList = new ArrayList<>();
        for(Persons p : persons) {
            personsInfoList.add(PersonsInfo.builder()
                    .name(p.getName())
                    .achieve(p.getAchieve())
                    .build());
        }
        return new FundingsDetailResponseDto(fundings,personsInfoList);
    }
}
