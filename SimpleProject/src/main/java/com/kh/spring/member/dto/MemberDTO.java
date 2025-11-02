package com.kh.spring.member.dto;

import java.sql.Date;

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
public class MemberDTO {
	
	private Long memberNo;
	private String memberId; 
	private String memberPwd; 
	private String nickname; 
	private String email;
	private Date enrollDate;
	private String status;
	private String address;
	private String phone; 
}
