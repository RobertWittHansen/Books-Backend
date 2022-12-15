package com.example.booksbackend.apiController;


import com.example.booksbackend.entityModel.Member;
import com.example.booksbackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping(path = "/{member_id}")
    public Member getMember(@PathVariable String member_id){
        return memberService.getMember(member_id);
    }

    @PostMapping("/")
    public Member createMember(@RequestBody Member member){
        return memberService.createMember(member);
    }

    @PutMapping("/{member_id}")
    public Member editMember(@RequestBody Member member, @PathVariable int member_id){
        return memberService.editMember(member);
    }
    @DeleteMapping("/{member_id}")
    public Member deleteMember(@PathVariable String member_id){
        return memberService.deleteMember(member_id);
    }


}
