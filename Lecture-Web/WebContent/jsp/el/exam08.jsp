<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.co.mlec.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
/*
//1. 자바빈즈클래스 + 콜렉션
	BoardVO board = new BoardVO();
	board.setTitle("성공");
	
	List<BoardVO> boardList = new ArrayList<>();
	boardList.add(board);
	
	pageContext.setAttribute("boardList", boardList);
*/
/*  
//2. 자바빈즈클래스 + 배열
	BoardVO board = new BoardVO();
	board.setTitle("성공");
	BoardVO[] boardList = {board};
	
	pageContext.setAttribute("boardList", boardList);
*/
/* 
//3. Map객체 + 배열
	Map<String, String> board = new HashMap<>();
	board.put("title", "성공");
	Map[] boardList = {board};
	
	pageContext.setAttribute("boardList", boardList);
*/

//4. Map객체 + 콜렉션
	Map<String, String> board = new HashMap<>();
	board.put("title", "성공");
	
	List<Map<String, String>> boardList = new ArrayList<>();
	boardList.add(board);
	
	pageContext.setAttribute("boardList", boardList);

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	성공/실패? ${ boardList[0].title }<br>
	

	
</body>
</html>