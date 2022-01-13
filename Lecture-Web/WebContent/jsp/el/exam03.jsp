<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	객체등록 : 공유영역.setAttribute("이름","값")
	공유영역 4가지 : pageContext, request, sessiom, application (영역 소 -> 대)
	*/
    pageContext.setAttribute("msg", "page영역에 객체 등록");
	String msg = (String)pageContext.getAttribute("msg");  //obj이라 무조건 stirng으로 형변환 해줘야함
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg : <%= pageContext.getAttribute("msg") %><br>
	msg : <%= msg %><br>
	
	<%-- 
	EL에서 공유영역 4가지 : pageScope, sessionScope, applicationScope>
	 --%>
	 
	
	msg : ${msg}<br>
	request msg : ${ requestScope.msg }<br>
	session msg : ${ sessionScope.msg }<br>
</body>
</html>