package com.kh.spring.review.model.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDto {
	private int productNo;
	private int reviewNo;
	private String reviewWriter;
	private Date writeDate;
	private int count;
	private String reviewContent;
	private char deleteStatus;
	private int score;
	private List<ReplyDto> replies;
	

}
