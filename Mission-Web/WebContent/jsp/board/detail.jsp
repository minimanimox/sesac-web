<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%--
   http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=1
      이 주소 날라옴
      
            작업순서
      1.요청 url의 파라미터 분석 => 게시글 번호 추출
      2.db tbl_board에서 추출된 게시글번호의 게시물 조회 
      3.html에 조회된 게시물 연결
      4.db연결 종료    
  --%>
<%
   //1.
   int boardNo = Integer.parseInt(request.getParameter("no"));
   //조회하기 System.out.println("boardNo" + boardNo);
   //스트링형이라서  정수를 문자열로 바꿈
   
   //2.
   BoardDAO dao = new BoardDAO();
   BoardVO board = dao.selectBoardByNo(boardNo);
    
   //공유영역 등록(jsp에서 el,jstl 접근하기 위해서)
   pageContext.setAttribute("board", board);
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세페이지</title>
<link rel = "stylesheet" href="/Mission-Web/css/layout.css">
<link rel = "stylesheet" href="/Mission-Web/css/board.css">
<script>
	function doAction(type) {
		
		switch(type) {
		case 'U' :
			location.href= "updateForm.jsp?no=${ param.no }" //board.no써도 됨
			break;
		case 'D' :
			break;
		case 'L' :
			location.href= "list.jsp"
			break;
		}
		
	}

</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align= "center">
		<hr>
		<h2>게시판 상세</h2>
		<hr>
		<br>
		<table border="1">
			<tr>
				<th width="25%">번호</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.regDate }</td>
			</tr>
		</table>
		<br>
		<button onclick="doAction('U')">수정</button>
		<button onclick="doAction('D')">삭제</button>
		<button onclick="doAction('L')">목록</button>
	</div>	
	</section> 	
	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>	
</body>
</html>


