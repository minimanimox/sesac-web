package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String saveFolder = "D:\\web-workspace\\Mission-Web-MVC\\WebContent\\upload";
		
		MultipartRequest multi = new MultipartRequest(request, 
														saveFolder,  //저장위치
														1024*1024*3, //3메가까지 허용
														"utf-8",     //encoding 방식
														new SesacFileNamePolicy() //동명의 파일이 올라갈수 없으므로 
																				//save folder에 올릴때 다른이름을 만들기 위한 규약
													);
				
		//제목, 작성자, 내용 추출
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardService service = new BoardService();
		service.insertBoard(board);
		
		
		//이런식으로 못읽어옴 null값뜸
		//String title = request.getParameter("title");
		//System.out.println("title: " + title);
		
		
		return "redirect:/board/list.do";
	}

}
