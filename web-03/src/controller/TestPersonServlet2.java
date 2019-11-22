package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPersonServlet2
 */
@WebServlet("/testPerson2")
public class TestPersonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPersonServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		
		String[] foodArr = request.getParameterValues("food");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>개인 취향 테스트 결과 화면</title></head>");
		out.println("<body>");
		
		out.println("<h2 style='color:red;'>개인 취향 테스트 결과(POST)</h2>");
		out.printf("<span style='color:lightblue; font-weight:bold;'>%s</span> 님의 개인 취향은<br><br>", name);
		out.printf("<span style='color:lightgreen; font-weight:bold;'>%s</span> 색을 좋아하고, "
				+ "<span style='color:hotpink; font-weight:bold;'>%s</span>를 좋아합니다.<br><br>", color, animal);
		
		out.print("좋아하는 음식은 ");
		
		for(int i = 0; i < foodArr.length; i++) {
			if(i == 0) {
				out.printf("%s", foodArr[i]);
			}else {
				out.printf(", %s", foodArr[i]);
			}
		}
		
		out.print("입니다.");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}












