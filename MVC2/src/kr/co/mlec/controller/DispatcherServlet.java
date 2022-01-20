package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	
	private HandlerMapping mappings = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String propLoc = config.getInitParameter("propLocation");
		mappings = new HandlerMapping(propLoc);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("요청처리");

		String uri = request.getRequestURI();
		String context = request.getContextPath(); // /Mission-Web-MVC 를 뜻함
		uri = uri.substring(context.length());
		
		//System.out.println("요청 URI : " + uri);
		
		
		try {

			Controller control = mappings.getController(uri);

			String callPage = control.handleRequest(request, response); // forward시킬 jsp 주소도 알려줌
			
			// <jsp:forward>는 jsp파일에서만 가능해서 여기서 못씀
			// forword or sendRedirect선택 
			// 앞에 접두어 redirect붙이면 두번째 경우
			if(callPage.startsWith("redirect:")) {
				callPage = callPage.substring("redirect:".length());
				response.sendRedirect((request.getContextPath() + callPage));
			} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
