package kr.co.mlec.member;


	@WebServlet("/MemberList")//web.xml을 대신해서 만들어진 것

	//서블릿을 맵핑해서 요청하는 주소를 설정할 수 있다.

	public class MemberList extends HttpServlet {

		

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) 

	throws ServletException, IOException {

			

			Connection conn = null;

			String sql = "select * from member";

			Statement stmt = null; //sql을 실행

			ResultSet rs = null; //쿼리문의 결과를 받는다.

			resp.setContentType("text/html; charset=UTF-8");

			PrintWriter out = resp.getWriter();

			out.print("<html>");

			out.print("<body>");

			try {

				Class.forName("com.mysql.jdbc.Driver");//붙여넣은 mysql lib을 사용해서 접속준비

				conn = DriverManager.getConnection(url,uid,upw);//접속

				stmt = conn.createStatement(); //sql을 실행할 준비

				rs = stmt.executeQuery(sql); //쿼리 sql을 실행하고 ResultSet 객체가 받는다.

				out.print("<table border='1'>");

				out.print("<tr>"

						+ "<th>num</th>"

						+ "<th>id</th>"

						+ "<th>pwd</th>"

						+ "<th>name</th>"

						+ "<th>email</th>"

						+ "<th>phone</th>"

						+ "<th>indate</th>"

						+ "<th>admin</th>"

						+ "</tr>");

				while(rs.next()){

					out.print("<tr>");

					out.print("<td>"+rs.getInt("num")+"</td>");

					out.print("<td>"+rs.getString("id")+"</td>");

					out.print("<td>"+rs.getString("pwd")+"</td>");

					out.print("<td>"+rs.getString("name")+"</td>");

					out.print("<td>"+rs.getString("email")+"</td>");

					out.print("<td>"+rs.getString("phone")+"</td>");

					out.print("<td>"+rs.getString("indate")+"</td>");

					out.print("<td>"+rs.getString("admin")+"</td>");

					out.print("</tr>");

				}

				out.print("</table>");

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				try {

					if(rs!=null)rs.close();

					if(stmt!=null)stmt.close();

					if(conn!=null)conn.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

			}

			out.print("</html>");

			out.print("</body>");

			//resp.getWriter().append("<html>").append("<h1 style='color: red;'>おはようございます。</h1>").append("</html>");

		}

	}

	출처:https:// cbts.tistory.com/153?category=651229 [IT일기장]

}
