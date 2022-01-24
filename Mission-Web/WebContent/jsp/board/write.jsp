<%@page import="kr.co.mlec.board.vo.MBoardVO"%>
<%@page import="kr.co.mlec.board.dao.MBoardDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- 작업순서
     1.writeForm.jsp에서 넘겨준 제목(title), 글쓴이(writer), 내용(content) 추출
     2.tbl_board 테이블에 추출된 정보로 새 게시글 삽입(insert)
--%>

<%
	//요청객체 데이터 인코딩 -- 포스트 방식
	request.setCharacterEncoding("utf-8");
	// 요청객체에서 입력한 데이터 추출
 	String title= request.getParameter("title");
 	String writer= request.getParameter("writer");
	String content = request.getParameter("content");
 	
 	MBoardVO board = new MBoardVO();
 	board.setTitle(title);
 	board.setWriter(writer);
 	board.setContent(content);
 	
    //데이터베이스 tbl_board 테이블에 새글등록
    MBoardDAO dao = new MBoardDAO();
    dao.insertBoard(board);
%>

<script>
alert('새글 등록 완료')
location.href ='list.jsp'
</script>



