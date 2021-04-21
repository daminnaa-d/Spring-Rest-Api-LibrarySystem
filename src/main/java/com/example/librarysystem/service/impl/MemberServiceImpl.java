package com.example.librarysystem.service.impl;

import com.example.librarysystem.entity.Member;
import com.example.librarysystem.repository.MemberRepository;
import com.example.librarysystem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void createMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.saveAndFlush(member);
    }

    @Override
    public void updateMember(Long id, Member member) {
        Member memberDb = memberRepository.findById(id).orElse(null);

        if (memberDb != null) {
            memberDb.setUsername(member.getUsername());
            memberDb.setPassword(member.getPassword());

            memberRepository.saveAndFlush(memberDb);
        }
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username);

        if (member == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
        return member;
    }


}
