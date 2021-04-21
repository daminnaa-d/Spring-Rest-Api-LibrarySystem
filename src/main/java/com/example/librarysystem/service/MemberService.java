package com.example.librarysystem.service;

import com.example.librarysystem.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();
    void createMember(Member member);
    void updateMember(Long id, Member member);
    void deleteMember(Long id);
}
