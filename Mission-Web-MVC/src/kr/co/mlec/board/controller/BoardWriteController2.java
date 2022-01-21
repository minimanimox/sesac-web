package kr.co.mlec.board.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardWriteController2 implements Controller {

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
				
		//제목, 작성자, 내용 추출 ==> tbl_board에 저장
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardService service = new BoardService();
		//service.insertBoard(board);
		
		
		//첨부파일 추출(file_ori_name, file_save_name, file_size) ==> tbl_board_file에 저장하는 것이 목적
		Enumeration<String> files = multi.getFileNames();
		while(files.hasMoreElements()) {
			String fileName = files.nextElement();
			// System.out.println(fileName);
			
			//multi.getFile("attachfile1"); ---> 이렇게 안쓰고 호환 가능하도록 
			File file = multi.getFile(fileName); //파일에 대한 정보 받아옴
			
			if(file!= null) {
				String fileOriName = multi.getOriginalFileName(fileName);
				String fileSaveName = multi.getFilesystemName(fileName);
				int fileSize = (int)file.length();
				
				BoardFileVO fileVO = new BoardFileVO();
				fileVO.setFileOriName(fileOriName);
				fileVO.setFileSaveName(fileSaveName);
				fileVO.setFileSize(fileSize);
				
			}
			
		}
		
		
		//이런식으로 못읽어옴 null값뜸
		//String title = request.getParameter("title");
		//System.out.println("title: " + title);
		
		
		return "redirect:/board/list.do";
	}

}
