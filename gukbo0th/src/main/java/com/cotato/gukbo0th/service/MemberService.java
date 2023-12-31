package com.cotato.gukbo0th.service;

import com.cotato.gukbo0th.domain.Members;
import com.cotato.gukbo0th.domain.MembersRepository;
import com.cotato.gukbo0th.dto.MemberJoinRequest;
import com.cotato.gukbo0th.dto.MemberLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MembersRepository membersRepository;

    public Members join(MemberJoinRequest memberJoinRequest) {
        //중복 체크
        if (membersRepository.existsByEmail(memberJoinRequest.getEmail())) {
            return null;
        } else {
            Members members = new Members(memberJoinRequest.getEmail(),memberJoinRequest.getName(), memberJoinRequest.getPassword());
            return membersRepository.save(members);
        }
    }

    public boolean login(MemberLoginRequest memberLoginRequest) {
        if (!membersRepository.existsByEmail(memberLoginRequest.getEmail())) {
            return false;
        } else {
            Members members = membersRepository.findByEmail(memberLoginRequest.getEmail());
            return members.getPassword().equals(memberLoginRequest.getPassword());
        }
    }
}
