package com.example.booksbackend.service;


import com.example.booksbackend.entityModel.Member;
import com.example.booksbackend.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    public Member getMember(int memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not Found"));
    }
    public Member createMember(Member member){
        return memberRepository.save(member);
    }
    public Member editMember(Member member) {
        return memberRepository.save(member);
    }
    public Member deleteMember(int memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if(member.isPresent()){
            memberRepository.delete(member.get());
        }
        return member.orElse(null);
    }
}

