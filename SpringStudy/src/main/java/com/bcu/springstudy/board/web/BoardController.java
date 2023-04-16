package com.bcu.springstudy.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcu.springstudy.board.dto.BoardDTO;
import com.bcu.springstudy.board.dto.ReplyDTO;
import com.bcu.springstudy.board.service.BoardService;
import com.bcu.springstudy.commons.Search;
import com.bcu.springstudy.member.dto.MemberDTO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@ExceptionHandler(Exception.class)
	public String errorPage(Exception e, Model model) {
		
		String errMsg = e.getMessage();
		model.addAttribute("errMsg", errMsg);
		
		return "errorPage";
	}
	
	
	// 게시판 화면으로 이동
	@RequestMapping("/boardView")
	public String boardView(Model model) {
		
		List<BoardDTO> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "board/boardView";
	}
	
	// 글쓰기 화면 요청
	@RequestMapping("/writeBoardView")
	public String writeBoardView(HttpSession session) {
		
		// 로그인 여부 체크
		if(session.getAttribute("login") == null) {
			// 로그인 안되어 있으면 로그인 페이지로 보낸다.
			return "redirect:/loginView";
		}
		
		return "board/writeBoardView";
	}
	
	
	// 글 등록 요청
	@PostMapping("/writeBoardDo")
	public String writeBoardDo(BoardDTO board, HttpSession session) throws Exception {
		System.out.println(board);
		
		// Object 로 리턴
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		System.out.println(login);
		
		board.setMemId(login.getMemId());
		
		// DB에 board 데이터 insert 예정
		boardService.writeBoard(board);
		
		return "redirect:/boardView";
	}
	
	// 글 상세보기 화면 요청
	@RequestMapping("/detailBoardView")
	public String detailBoardView(int boardNo, Model model) throws Exception {
		
		System.out.println(boardNo);
		
		// DB로부터 boardNo가 3인 데이터를 하나 꺼내와서
		BoardDTO board = boardService.getBoard(boardNo);
		
		// 댓글 목록 가져오기
		List<ReplyDTO> replyList = boardService.getReplyList(boardNo);
		
		// detailBoardView.jsp 로 넘겨주어야 한다. (Model)
		model.addAttribute("board", board);
		model.addAttribute("replyList", replyList);
		
		return "board/detailBoardView";
	}
	
	@PostMapping("/boardEditView")
	public String boardEditView(int boardNo, Model model) throws Exception {
		
		System.out.println(boardNo);
		
		// boardNo 에 대한 게시글 데이터를 DB로부터 가져온 뒤
		BoardDTO board = boardService.getBoard(boardNo);
		// boardEditView.jsp에 전달
		model.addAttribute("board", board);
		
		return "board/boardEditView";
	}
	
	@PostMapping("/boardEditDo")
	public String boardEditDo(BoardDTO board) throws Exception {
		
		System.out.println(board);
		
		boardService.editBoard(board);
		
		return "redirect:/boardView";
	} 
	 
	@PostMapping("/boardDelDo")
	public String boardDelDo(int boardNo) throws Exception {
		
		System.out.println(boardNo);
		
		boardService.delBoard(boardNo);
		
		return "redirect:/boardView";
	}
	
	@RequestMapping("/searchBoard")
	public String searchBoard(Search search, Model model) {
		
		System.out.println(search);
		
		// keyword에 공백이 포함되어 있다면 제거하기
		search.setKeyword(search.getKeyword().replace(" ", ""));
		
		// DB에서 해당 keyword를 포함하는 데이터 목록을 가지고 온다.
		List<BoardDTO> boardList = boardService.searchBoardList(search);
		
		// model에 해당 데이터목록을 담아준다.
		model.addAttribute("boardList", boardList);
		
		return "board/boardView";
	}
	
	@PostMapping("/writeReplyDo")
	@ResponseBody
	public ReplyDTO writeReplyDo(ReplyDTO reply, HttpSession session
			, HttpServletRequest request) throws Exception {
		
		System.out.println(reply);
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		
		// DB에 댓글 정보 저장 (replyContent, 로그인 중인 아이디, 게시글 번호)
		reply.setMemId(login.getMemId());
		
		boardService.writeReply(reply);
		
		// 어느 URL로부터  요청이 왔는지 알아보기
		String fromUrl = request.getHeader("Referer");
		System.out.println(fromUrl);
		
		return reply;
	}
	

	
	
	
	
	
	
	
	
	
}
