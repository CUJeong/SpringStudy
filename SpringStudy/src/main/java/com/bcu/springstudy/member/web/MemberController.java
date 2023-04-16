package com.bcu.springstudy.member.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcu.springstudy.member.dto.MemberDTO;
import com.bcu.springstudy.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@ExceptionHandler(Exception.class)
	public String errorPage(Exception e, Model model) {
		
		String errMsg = e.getMessage();
		model.addAttribute("errMsg", errMsg);
		
		return "errorPage";
	}
	

	// 회원가입 화면을 제공하는 메소드
	@RequestMapping("/registView")
	public String registView() {
		
		return "member/registView";
	}
	
	// 회원가입을 진행하는 메소드
	@PostMapping("/registDo")
	public String registDo(HttpServletRequest request, Model model) throws Exception {
		
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		System.out.println("id: " + id);
		System.out.println("pw: " + pw);
		System.out.println("name: " + name);
		
		MemberDTO member = new MemberDTO(id, pw, name);
		
		// DB에 요청받은 데이터 전송
		service.registMember(member);
		
		return "redirect:/";
	}
	
	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, Model model) {
		
		// /boardView
		String fromUrl = request.getHeader("Referer");
		model.addAttribute("fromUrl", fromUrl);
		
		return "member/loginView";
	}
	
	 
	@PostMapping("/loginDo")
	public String loginDo(MemberDTO member, HttpSession session, String fromUrl
			, Model model, boolean rememberId, HttpServletResponse response) throws Exception {
		
		System.out.println(member);
		System.out.println(rememberId);
		System.out.println(fromUrl);
		
		MemberDTO login = service.loginMember(member);
		session.setAttribute("login", login);
		
		if(rememberId == true) {
			// 쿠키 생성
			Cookie cookie = new Cookie("rememberId", login.getMemId());
			
			// 쿠키의 만료시간 설정 (단위: 초)
			cookie.setMaxAge(60 * 60 * 24 * 30);
			
			// response 객체에 쿠키 담아서 보내기
			response.addCookie(cookie);
		}else {
			// 쿠키 삭제
			// 키값이 같은 쿠키 생성
			Cookie cookie = new Cookie("rememberId", "");
			// 이 쿠키의 만료시간을 0으로 설정
			cookie.setMaxAge(0);
			// response 객체에 쿠키 담아서 보내기
			response.addCookie(cookie);
		}
		
		return "redirect:" + fromUrl;
	}
	
	@RequestMapping("/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		// 로그아웃시 세션을 삭제
		session.invalidate();
		
		// 어느 URL로부터 /logoutDo를 요청하였는지 알아보기
		String fromUrl = request.getHeader("Referer");
		System.out.println(fromUrl);
		
		return "redirect:" + fromUrl;
	}
	
	@RequestMapping("/editView")
	public String editView() {
		
		return "member/editView";
	}
	
	@RequestMapping("/editDo")
	public String editDo(MemberDTO member, HttpSession session) throws Exception {
		
		System.out.println(member);
		
		// DB에 회원 수정 요청
		service.editMember(member);
		
		// 세션에 저장된 로그인된 회원 정보 갱신
		session.setAttribute("login", member);
		
		return "redirect:/";
	}
	
	
	
}
