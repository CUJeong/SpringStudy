package com.bcu.springstudy.board.dto;

public class BoardDTO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String memId;
	private String memName;
	private String boardDate;
	
	
	public BoardDTO(int boardNo, String boardTitle, String boardContent, String memId, String memName,
			String boardDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memId = memId;
		this.memName = memName;
		this.boardDate = boardDate;
	}
	
	public BoardDTO() {}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", memId=" + memId + ", memName=" + memName + ", boardDate=" + boardDate + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
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

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
	
}
