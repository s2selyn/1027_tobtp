package com.kh.spring.review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyDto {

	private Long replyNo;
	private int refRno;
	private String replyContent;
	private String replyWriter;
	private String writeDate;
	private String status;
}