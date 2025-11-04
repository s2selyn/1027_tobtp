package com.kh.spring.review.controller;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.review.model.dto.ReviewDto;
import com.kh.spring.review.model.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;
	
	@GetMapping("reviews")
	public String findAll(@RequestParam(name="page", defaultValue="1") Long page, Model model) {
		log.info("앞에서 넘어온 페이지 값 : {}", page);
		// 페이징처리 : 게시글 개수, 페이지당 노출 개수, 제시할 버튼 수
		
		Map<String, Object> map = reviewService.findAll(page);
		model.addAttribute("map", map);
		
		
		return "review/list";
	}
	@GetMapping("reviews/form")
	public String toForm() {
		
		return "review/form";
	}
	  
	
		
	
	
	@PostMapping("boards")
	public String save(ReviewDto review, MultipartFile upfile, HttpSession session) {
		log.info("게시글 정보 : {}, 파일 정보 : {}", review, upfile);
		// 첨부파일의 존재 유무
		// MultipartFile 개체의 fileName 필드값으로 확인해야 함.
		reviewService.save(review, upfile, session);
		
		return "redirect:reviews";
	}
	
	
}
