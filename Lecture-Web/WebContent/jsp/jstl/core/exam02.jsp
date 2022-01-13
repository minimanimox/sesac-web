<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="내 이름은 <b>홍길동</b>입니다" /><br>
	<c:out value="내 이름은 <b>홍길동</b>입니다" escapeXml="false" /><br>
	msg : <c:out value="${ msg }" default="msg변수 미설정" />"
</html>