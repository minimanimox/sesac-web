<%@page import="kr.co.mlec.board.dao.MBoardDAO"%>
<%@page import="kr.co.mlec.board.vo.MBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	
	//수정할 제목, 작성자, 내용 추출
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	int no = Integer.parseInt(request.getParameter("no"));
	
	MBoardVO board = new MBoardVO();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setNo(no);
	
	MBoardDAO dao = new MBoardDAO();
	dao.updateBoard(board);
%>

<script>
	alert('${ param.no}번 게시물이 수정되었습니다')
	location.href = 'detail.jsp?no=${ param.no }'
			
</script>
    