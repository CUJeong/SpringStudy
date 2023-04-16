package com.bcu.springstudy.board.dto;

public class ReplyDTO {
	private String replyContent;
	private String memId;
	private String memName;
	private int boardNo;
	
	public ReplyDTO(String replyContent, String memId, String memName, int boardNo) {
		super();
		this.replyContent = replyContent;
		this.memId = memId;
		this.memName = memName;
		this.boardNo = boardNo;
	}
	
	public ReplyDTO() {}

	@Override
	public String toString() {
		return "ReplyDTO [replyContent=" + replyContent + ", memId=" + memId + ", memName=" + memName + ", boardNo="
				+ boardNo + "]";
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
}
