<%@page import="kr.co.mlec.board.dao.MBoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.mlec.board.vo.MBoardVO"%>
<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	/* tbl_board에서 전체게시글(번호, 제목, 작성자, 등록일) 조회 */
	
    
    MBoardDAO dao = new MBoardDAO();
	List<MBoardVO> list = dao.selectAllBoard();
	
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="/Mission-Web/css/layout.css" >
<link rel = "stylesheet" href="/Mission-Web/css/board.css" >
<script src="/Mission-Web/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('button').click(function() {
			location.href = "writeForm.jsp"
		})
	})
     
   function goWriteForm(){
      location.href = "writeForm.jsp"
   }
   
   function doAction(boardNo){
	   <c:choose>
	   		<c:when test="${ not empty userVO }">
	   			location.href = "detail.jsp?no=" + boardNo
	   					
			</c:when>
	   		<c:otherwise>
	   			if(confirm('로그인 서비스가 필요합니다\n로그인페이지로 이동하시겠습니까?')){
	   				location.href = '/Mission-Web/jsp/login/loginForm.jsp'
	   			}	
	   		</c:otherwise>
   	   </c:choose>
   }
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
      <hr>
      <h2>게시판 목록</h2>
      <hr>
      <br>
      <table border = "1" class="list">
         <tr>
            <th width="7%">번호</th>
            <th>제목</th>
            <th width = "16%">글쓴이</th>
            <th width = "10%">조회수</th>
            <th width = "20%">등록일</th>
         </tr>
		 
		<c:forEach items="${ list }" var="board">
		 <tr>
		 	<td>${ board.no }</td>
		 	<td>
		 		<a href="javascript:doAction(${ board.no })">
		 			<c:out value="${ board.title }" />
		 		</a>
		 		
		 		<%-- <a href="detail.jsp?no=${ board.no }">
		 			<c:out value="${ board.title }" />
		 		</a> --%>
		 	</td>
		 	<td>${ board.writer }</td>
		 	<td>${ board.viewCnt }</td>
		 	<td>${ board.regDate }</td>
		 </tr>
		</c:forEach>
      </table>
      <br>
      <c:if test="${ not empty userVO }">
      <!-- <button onclick="goWriteForm()">새글등록</button> -->
      <button>새글등록</button>
      </c:if>
   </div>	
	</section> 	
	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>	
</body>
</html>

