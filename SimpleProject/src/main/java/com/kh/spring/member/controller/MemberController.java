package com.kh.spring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.dto.MemberDTO;
import com.kh.spring.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/login")
	public ModelAndView login(MemberDTO member,
							  HttpSession session,
							  ModelAndView mv) {
		
		MemberDTO loginMember = memberService.login(member);
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("msg", "로그인실패!")
			  .setViewName("include/error_page");
		}
		return mv;
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginMember");
		return "redirect:/";
	}
	
	
	@GetMapping("join")
	public String joinForm() {
		return "member/signup";
	}
	
	@PostMapping("signup")
	public String signup(MemberDTO member
						) {
		log.info("{}", member);
		memberService.signUp(member);
		return "main";
	}
	
	@GetMapping("mypage")
	public String myPage() {
		return "member/my_page";
	}
	
	@PostMapping("edit")
	public String edit(MemberDTO member, HttpSession session) {
		log.info("값 찍어보기 : {}", member);
		memberService.update(member, session);
		return "redirect:mypage";
	}
	
	@PostMapping("delete")
	public String delete(@RequestParam(value="userPwd") String userPwd,
						 HttpSession session) {
	
		memberService.delete(userPwd, session);
		session.removeAttribute("loginMember");
		return "redirect:/";
	}

}
