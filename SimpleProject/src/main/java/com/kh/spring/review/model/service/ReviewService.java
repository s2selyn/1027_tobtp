package com.kh.spring.review.model.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.review.model.dto.ReplyDto;
import com.kh.spring.review.model.dto.ReviewDto;

public interface ReviewService {
	// 게시글 목록 조회 + 페이징 처리, 게시글 작성, 게시글 상세보기(조회수 증가 처리), 게시글 삭제, 게시글 수정
	
	
	
	
	Map<String, Object> findAll(Long reviewNo);
	
	
	
	int save(ReviewDto review, MultipartFile upfile, HttpSession session);
	
	
	
	int deleteByReviewNo(Long reviewNo);
	
	
	
	int update(ReviewDto board);
	
	int insertReply(ReplyDto reply, HttpSession session);
	
	
	// 댓글 서비스
	
}
