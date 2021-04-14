package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Member;
import com.example.librarysystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("")
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id) {
        return memberRepository.findById(id).get();
        }

    @PostMapping("")
    public Member addNewMember(@RequestBody Member member){
        return memberRepository.save(member);

    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,
                               @RequestBody Member member){
        member.setMember_id(id);
        return memberRepository.saveAndFlush(member);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id){
        memberRepository.deleteById(id);
        return "Member with ID: " + id + ", was deleted!";
    }

}

