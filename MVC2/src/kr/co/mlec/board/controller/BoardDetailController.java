package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;

public class BoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		BoardService service = new BoardService();
		BoardVO vo = new BoardVO(); 
		service.selectBoardByNo(vo.getNo());
		
		request.setAttribute("vo", vo);
		
		return "/jsp/board/detail.jsp";
	}

}
