package com.bcu.springstudy.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcu.springstudy.member.dao.IMemberDAO;
import com.bcu.springstudy.member.dto.MemberDTO;

// 얘도 Bean으로 등록이 되어야 한다.
@Service
public class MemberService {
	
	// Bean에 등록된 객체 자동으로 가지고 오기
	@Autowired
	IMemberDAO dao;

	// 회원가입 진행 메소드
	public void registMember(MemberDTO member) throws Exception {
		
		try {
			dao.registMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원가입에 실패하였습니다.");
		}

	}
	
	// 로그인 진행 메소드
	public MemberDTO loginMember(MemberDTO member) throws Exception {
		
		MemberDTO result = dao.loginMember(member);
		
		if(result == null) {
			throw new Exception("아이디 혹은 비밀번호가 틀립니다.");
		}
		
		return result;
	}
	 
	public void editMember(MemberDTO member) throws Exception {
		int result = dao.editMember(member);
		
		if(result < 1) {
			throw new Exception();
		}
	}
	
	
	
	
}
