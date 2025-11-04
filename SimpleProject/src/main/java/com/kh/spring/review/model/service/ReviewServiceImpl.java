package com.kh.spring.review.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.exception.AuthenticationException;
import com.kh.spring.exception.InvalidArgumentsException;
import com.kh.spring.member.dto.MemberDTO;
import com.kh.spring.review.model.dto.ReplyDto;
import com.kh.spring.review.model.dto.ReviewDto;
import com.kh.spring.review.model.mapper.ReviewMapper;
import com.kh.spring.util.PageInfo;
import com.kh.spring.util.Pagination;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewMapper reviewMapper;
	private final Pagination pagination;
	
	@Override
	public Map<String, Object> findAll(Long page) {

		Map<String, Object> map = new HashMap();
		List<ReviewDto> reviews = new ArrayList();
		// DTO보다 나은 점 : 개발의 용이성, 유지보수의 편의성.
		// Key와 Value의 형태로 저장하므로 값을 효율적으로 저장하기에 좋다.
		
		// 유효성 검증을 해야 함.
		if(page < 1) {
			throw new InvalidArgumentsException("잘못된 접근입니다.");
		}
		int count = reviewMapper.selectTotalCount();
		PageInfo pi = pagination.getPageInfo(count, page.intValue(), 5, 5);
		
		if(count > 0) {
			RowBounds rb = new RowBounds((page.intValue() - 1) * 5, 5);
			reviews = reviewMapper.findAll(rb);
		}
		
		
		return null;
	}
	
	private void validateUser(ReviewDto review, HttpSession session) {
		String reviewWriter = review.getReviewWriter();
		MemberDTO loginMember = ((MemberDTO)session.getAttribute("loginMember"));
		if(loginMember == null || !reviewWriter.equals(loginMember.getMemberId())) {
			throw new AuthenticationException("권한 없는 접근입니다.");
		}
	}
		
	@Override
	public int save(ReviewDto review, MultipartFile upfile, HttpSession session) {
		validateUser(review, session); 
		return 0;
	}

	
	@Override
	public int deleteByReviewNo(Long reviewNo) {
		return 0;
	}

	@Override
	public int update(ReviewDto review) {
		return 0;
	}

	@Override
	public int insertReply(ReplyDto reply, HttpSession session) {
		MemberDTO loginMember = ((MemberDTO)session.getAttribute("loginMember"));
		if(loginMember == null) {
			throw new AuthenticationException("구면인 듯");
		}
		
		int reviewNo = reply.getRefRno();
		ReviewDto review = reviewMapper.findByReviewNo(reviewNo);
		// 유효값 검증
		reply.setReplyWriter(loginMember.getMemberId());
		return 0;
	}

}
