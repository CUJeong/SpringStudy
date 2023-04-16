package com.bcu.springstudy.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcu.springstudy.board.dao.IBoardDAO;
import com.bcu.springstudy.board.dto.BoardDTO;
import com.bcu.springstudy.board.dto.ReplyDTO;
import com.bcu.springstudy.commons.Search;

@Service
public class BoardService {
	
	@Autowired
	IBoardDAO dao;
	
	public List<BoardDTO> getBoardList(){
	    List<BoardDTO> result = dao.getBoardList();
		
	    return result;
	}
	
	public void writeBoard(BoardDTO board) throws Exception {
		int result = dao.writeBoard(board);
		
		if(result < 1) {
			throw new Exception("글 등록에 실패하였습니다.");
		}
	}
	
	public BoardDTO getBoard(int boardNo) throws Exception {
		BoardDTO result = dao.getBoard(boardNo);
		
		if(result == null) {
			throw new Exception("없는 글 번호 입니다.");
		}
		
		return result;
	}
	
	public void editBoard(BoardDTO board) throws Exception {
		int result = dao.editBoard(board);
		
		if(result < 1) {
			throw new Exception();
		}
	}
	
	public void delBoard(int boardNo) throws Exception {
		int result = dao.delBoard(boardNo);
		
		if(result < 1) {
			throw new Exception();
		}
	}
	
	public List<BoardDTO> searchBoardList(Search search){
		List<BoardDTO> result = dao.searchBoardList(search);
		return result;
	}
	
	public void writeReply(ReplyDTO reply) throws Exception {
		int result = dao.writeReply(reply);
		
		if(result < 1) {
			throw new Exception("댓글 정보를 저장하는데 실패하였습니다.");
		}
	}
	
	public List<ReplyDTO> getReplyList(int boardNo){
		List<ReplyDTO> result = dao.getReplyList(boardNo);
		return result;
	}
	
	
	
}
