package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PagingVO;
import kr.co.mlec.controller.Controller;

// board/list.do(전체리스트조회) 호출되었을 때
/* 1.비즈니스 로직 수행 (DB 조회  tbl_board에서 전체게시글 조회)
 * 2.servlet에게 forward 시킬  jsp/board/list.jsp 알려줌
 * 
 */
public class BoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		BoardDAO dao = new BoardDAO();
		
		int page = 1;
		
		if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        PagingVO paging = new PagingVO();
        
        int count = dao.getAllCount();
		paging.setTotalCount(count);
		paging.setPage(page);
		
        BoardService service = new BoardService();
        List<BoardVO> list = service.selectAllBoard(paging);
        request.setAttribute("list", list);
        request.setAttribute("paging", paging);
        		
		return "/jsp/board/list.jsp?page="+page;
	}

}
