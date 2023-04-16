package com.bcu.springstudy.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bcu.springstudy.board.dto.BoardDTO;
import com.bcu.springstudy.board.dto.ReplyDTO;
import com.bcu.springstudy.commons.Search;

@Mapper
public interface IBoardDAO {
	// 게시글 가져오기(여러개 가져옴)
	public List<BoardDTO> getBoardList();
	
	// 게시글 작성
	public int writeBoard(BoardDTO board);
	
	// 게시글 조회(1개만)
	public BoardDTO getBoard(int boardNo);
	
	// 게시글 수정
	public int editBoard(BoardDTO board);
	
	// 게시글 삭제
	public int delBoard(int boardNo);
	
	// 게시글 검색
	public List<BoardDTO> searchBoardList(Search search);
	
	// 댓글 추가
	public int writeReply(ReplyDTO reply);
	
	// 댓글 목록 가져오기
	public List<ReplyDTO> getReplyList(int boardNo);
	
}
