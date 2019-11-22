package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestPersonServlet3
 */
@WebServlet("/testPerson3")
public class TestPersonServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPersonServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글에 대한 인코딩 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//2. request객체에서 값 꺼내 변수에 담기
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foodArr = request.getParameterValues("food");
		
		//3. 값에 대한 가공처리
		String foods = "";
		
		if(foodArr != null) {
			for(int i = 0; i < foodArr.length; i++) {
				if(i == 0) {
					foods += foodArr[i];
				}else {
					foods += ", " + foodArr[i];
				}
			}
		}
		
		//4. 비즈니스 로직 처리
		String recommendation = "";
		
		switch(color) {
			case "빨강" : recommendation = "빨간 페라리"; break;
			case "노랑" : recommendation = "노란 카레"; break;
			case "초록" : recommendation = "초록 붕어빵"; break;
			case "파랑" : recommendation = "파란 캔디바"; break;
		}
		
		request.setAttribute("name", name);
		request.setAttribute("color", color);
		request.setAttribute("animal", animal);
		request.setAttribute("foods", foods);
		request.setAttribute("recommendation", recommendation);
		
		RequestDispatcher view = request.getRequestDispatcher("views/result.jsp");
		view.forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






















