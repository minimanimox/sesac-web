package kr.co.mlec.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.MBoardService;
import kr.co.mlec.board.vo.MBoardFileVO;
import kr.co.mlec.board.vo.MBoardVO;
import kr.co.mlec.controller.Controller;

public class MBoardDetailController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MBoardService service = new MBoardService();
		//해당 게시글 + 첨부파일 조회
		Map<String, Object> result = service.detailBoard(no);
		
		MBoardVO board = (MBoardVO)result.get("board");
		List<MBoardFileVO> fileList = (List<MBoardFileVO>)result.get("fileList");
				
		// 공유영역 등록
		request.setAttribute("board", board);
		request.setAttribute("fileList", fileList);
		
		return "/jsp/board/detail.jsp";
		
		/*
		 * int no = Integer.parseInt(request.getParameter("no"));
		 * 
		 * BoardService service = new BoardService(); //해당 게시글 + 첨부파일 조회 Object[] arr =
		 * service.detailBoard(no);
		 * 
		 * BoardVO board = (BoardVO)arr[0]; List<BoardFileVO> fileList =
		 * (List<BoardFileVO>)arr[1];
		 * 
		 * // 공유영역 등록 request.setAttribute("board", board);
		 * request.setAttribute("fileList", fileList);
		 * 
		 * return "/jsp/board/detail.jsp";
		 */
	}

}
