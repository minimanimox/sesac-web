<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		alert('!!!')
		//$('ul li').hide()
		//$('ul li:first').hide()
		//$('ul li:last').hide()
		//$('ul li:first-child').hide()
		$('ul li:last-child').hide()
	})
</script>
</head>
<body>
	<h1>동물종류</h1>
	<ul>
		<li>호랑이</li>
		<li>사자</li>
		<li>코끼리</li>
	</ul>
	<h1>음식종류</h1>
	<ul>
		<li>샤브샤브</li>
		<li>피자</li>
		<li>떡볶이</li>
		<li>치킨</li>
	</ul>
</body>
</html>