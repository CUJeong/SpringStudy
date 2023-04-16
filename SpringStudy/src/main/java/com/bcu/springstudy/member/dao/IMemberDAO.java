package com.bcu.springstudy.member.dao;

import org.apache.ibatis.annotations.Mapper;
import com.bcu.springstudy.member.dto.MemberDTO;

// 서버가 실행되었을때, @Controller 처럼 빈(Bean)으로 등록하고 싶다.
@Mapper
public interface IMemberDAO {
	// 회원가입
	public int registMember(MemberDTO member);
	// 로그인
	public MemberDTO loginMember(MemberDTO member);
	
	// 회원수정
	public int editMember(MemberDTO member);
}
