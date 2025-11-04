package com.kh.spring.review.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.kh.spring.review.model.dto.ReplyDto;
import com.kh.spring.review.model.dto.ReviewDto;

@Mapper
public interface ReviewMapper {

	
	int selectTotalCount();
	
	List<ReviewDto> findAll(RowBounds rowBounds);
	
	int save(ReviewDto review);
	
	int increaseCount(int reviewNo);
	
	ReviewDto findByReviewNo(int reviewNo);
	
	ReviewDto findReviewAndReply(int reviewNo);
	
	int insertReply(ReplyDto reply);
	
	
}
