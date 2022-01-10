package kr.co.mlec.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/examMethod"})  //이게 정석으로 쓰는 방법
//@WebServlet("/examMethod")//web.xml 쓸 필요 없어짐
public class ExamMethodServlet extends HttpServlet {

	//http://localhost:9999/Lecture-Web/examMethod?name=hong&hobby=reading&hobby=movie
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name"); //getParameter한개값만 가져옴
		String[] hobby = request.getParameterValues("hobby"); //배열로 values추가 / 여러개값 받을수 있음
		
		System.out.println("name: " + name);
		System.out.println("hobby : " + Arrays.toString(hobby));
	}

	
}
