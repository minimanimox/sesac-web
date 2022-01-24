package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.MBoardService;
import kr.co.mlec.board.vo.MBoardVO;
import kr.co.mlec.controller.Controller;

// board/list.do(전체리스트조회) 호출되었을 때
/* 1.비즈니스 로직 수행 (DB 조회  tbl_board에서 전체게시글 조회)
 * 2.servlet에게 forward 시킬  jsp/board/list.jsp 알려줌
 * 
 */
public class MBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		MBoardService service = new MBoardService();
		List<MBoardVO> list = service.selectAllBoard();
		
		request.setAttribute("list", list);
		
		return "/jsp/board/list.jsp";
	}

}