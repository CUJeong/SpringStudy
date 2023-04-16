package com.bcu.springstudy.member.dto;

public class MemberDTO {
	// 변수명 규칙 적용 = 카멜식
	// step 1. 모든 필드변수에 각각 private 접근 제어자 붙인다.
	private String memId;
	private String memPw;
	private String memName;
	
	// step 2. 생성자를 만들어준다.
	// 단축키 [Alt + Shift + S] 후 Generate Constructor using fields..
	public MemberDTO(String memId, String memPw, String memName) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
	}
	
	// step 3. 기본 생성자도 만들어준다.
	public MemberDTO() {}

	
	// step 4. toString 을 만들어준다.
	// 단축키 [Alt + Shift + S] 후 Generate toString ...
	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + "]";
	}
	
	// step 5. Getter/Setter 를 만들어준다.
	// 단축키 [Alt + Shift + S] 후 Generate Getters and Setters...
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}
	
	
	
	
	
	

}
