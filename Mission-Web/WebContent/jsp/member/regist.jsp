<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<%

	request.setCharacterEncoding("utf-8");

	String id= request.getParameter("id");
	String password= request.getParameter("password");
	String name= request.getParameter("name");
	String email_id= request.getParameter("email_id");
	String email_domain= request.getParameter("email_domain");
	String tel1= request.getParameter("tel1");
	String tel2= request.getParameter("tel2");
	String tel3= request.getParameter("tel3");
	String post= request.getParameter("post");
	String basic_addr= request.getParameter("basic_addr");
	String detail_addr= request.getParameter("detail_addr");
	
	System.out.println("id : "+id);
	System.out.println("password : "+password);
	System.out.println("name : "+name);
	System.out.println("email_id : "+email_id);
	System.out.println("email_domain : "+email_domain);
	System.out.println("tel1 : "+tel1);
	System.out.println("tel2 : "+tel2);
	System.out.println("tel3 : "+tel3);
	System.out.println("post : "+post);
	System.out.println("basic_addr : "+basic_addr);
	System.out.println("detail_addr : "+detail_addr);

	  Connection conn = new ConnectionFactory().getConnection();
	  StringBuilder sql = new StringBuilder();
	  sql.append("insert into tbl_board(id, password, name, email_id, email_domain, ");
	  sql.append(" tel1, tel2, tel3, post, basic_addr, detail_addr )");
	  sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	  pstmt.setString(1, id);
	  pstmt.setString(2, password);
	  pstmt.setString(3, name);
	  pstmt.setString(4, email_id);
	  pstmt.setString(5, email_domain);
	  pstmt.setString(6, tel1);
	  pstmt.setString(7, tel2);
	  pstmt.setString(8, tel3);
	  pstmt.setString(9, post);
	  pstmt.setString(10, basic_addr);
	  pstmt.setString(11, detail_addr);
	  pstmt.executeUpdate();
%>

<script>
alert('회원가입 완료')
location.href='memlist.jsp'
</script>
