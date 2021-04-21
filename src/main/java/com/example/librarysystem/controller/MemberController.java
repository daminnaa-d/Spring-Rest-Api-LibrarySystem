package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Member;
import com.example.librarysystem.repository.MemberRepository;
import com.example.librarysystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello everyone!";
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // add user
    @GetMapping("/create")
    public void createUserByUsernamePassword(String username,
                                             String password) {
        Member member = new Member();
        member.setPassword(password);
        member.setUsername(username);

        memberService.createMember(member);
    }

    @PostMapping
    public void createMember(@RequestBody Member member) {
        System.out.println("MemberController.createMember");
        System.out.println("member = " + member);

        memberService.createMember(member);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody Member member) {

        System.out.println("MemberController.updateMember");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return "Member with ID: " + id + ", was deleted!";
    }

}

