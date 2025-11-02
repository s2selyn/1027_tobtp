package com.kh.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.member.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	@Select ("SELECT MEMBER_NO memberNo, MEMBER_ID memberrId, MEMBER_PWD memberPwd, NICKNAME nickname, EMAIL, ENROLL_DATE enrollDate, STATUS status, ADDRESS address, PHONE phone FROM TB_MEMBER WHERE MEMBER_ID = #{memberId}")
	MemberDTO login(MemberDTO member);
	
	@Insert ("INSERT INTO TB_MEMBER VALUES #{memberNo} #{memberId}, #{memberPwd}, #{nickame}, #{email}, SYSDATE, #{status}, #{address}, #{phone}")
	int signup(MemberDTO member);
	
	@Update ("UPDATE TM_MEMBER SET NICKNAME = #{nickname}, EMAIL = #{email} WHERE MEMBER_ID = #{memberId}")
	int update(MemberDTO member);
	
	@Delete("DELETE FROM TB_MEMBER WHERE MEMBER_ID = #{memberId}")
	int delete(String memberId );
	

}
