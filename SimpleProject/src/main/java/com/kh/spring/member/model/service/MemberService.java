package com.kh.spring.member.model.service;

import javax.servlet.http.HttpSession;

import com.kh.spring.member.model.dto.MemberDTO;

public interface MemberService {

	// 로그인
	MemberDTO login(MemberDTO member);
	
	// 회원가입
	void signUp(MemberDTO member);
	
	// 정보수정
	void update(MemberDTO member, HttpSession session);
	
	// 탈퇴
	void delete(String memberPwd, HttpSession session);

}
