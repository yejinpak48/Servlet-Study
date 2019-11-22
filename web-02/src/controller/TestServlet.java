package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		//1. 전송값에 한글이 있을 경우 처리할 수 있도록 인코딩 처리를 해야 함
		//   반드시 값을 꺼내기 전에 해야 한다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. view에서 보낸 전송 값을 꺼내서 변수에 저장하기
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//3. 비즈니스 로직 처리
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		
		//4. 웹 페이지에 스트림 연결
		PrintWriter out = response.getWriter();
		
		//5. 스트림을 통해서 문자열 형태로 화면 출력
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.println("아이디 : " + userId + "<br>");
		out.println("패스워드 : " + password);
		
		out.println("</body>");
		out.println("</html>");
		
		//6. 생성한 스트림 닫기
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		System.out.println("doPost 호출됨...");
		doGet(request, response);
	}
}





























