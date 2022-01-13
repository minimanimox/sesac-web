<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Connection conn = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" select * ");
	sql.append(" from tbl_member ");
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel= "stylesheet" href= "/Mission-Web/css/layout.css">
<link rel= "stylesheet" href= "/Mission-Web/css/board.css">

<script>
	function goRegisterForm() {
		location.href="registerForm.jsp"
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
		<h1>회원 목록</h1>
		<hr>
		<br>
		<table border = "1" class="list">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PASSWORD</th>
				<th>EMAIL</th>
				<th>TELEPHONE</th>
				<th>POST</th>
				<th>ADDRESS</th>
				<th>TYPE</th>
				<th>REG_DATE</th>
			</tr>
			<% //글 갯수만큼 tr을 만들어주겠다
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email_id = rs.getString("email_id");
				String email_domain = rs.getString("email_domain");
				String tel1 = rs.getString("tel1");
				String tel2 = rs.getString("tel2");
				String tel3 = rs.getString("tel3");
				String post = rs.getString("post");
				String basic_addr = rs.getString("basic_addr");
				String detail_addr = rs.getString("detail_addr");
				String type = rs.getString("type");
				String regDate = rs.getString("reg_date");
				
			%>
				<tr>
					<td><%= id %></td>					
                    <td><%= name %></td>
                    <td><%= password %></td>
                    <td><%= email_id %>@<%= email_domain %></td>
                    <td><%= tel1 %>-<%= tel2 %>-<%= tel3 %></td>
                    <td><%= post %></td>
                    <td><%= basic_addr %><%= detail_addr %></td>
                    <td><%= type %></td>
                    <td><%= regDate %></td>
				</tr>
			<%
			}
			%>
		</table>
		<br>
		<button onclick="goRegisterForm()">회원가입</button>	
			
	
	</div>
	</section>
	<footer>
	<%@ include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>
<%
	JDBCClose.close(pstmt, conn);
%>
