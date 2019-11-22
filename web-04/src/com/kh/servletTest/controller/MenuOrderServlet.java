package com.kh.servletTest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuOrderServlet
 */
@WebServlet("/menuOrder")
public class MenuOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. 전송값 꺼내서 변수에 기록
		String menu = request.getParameter("menu");
		
		//3. 비즈니스로직
		int price = 0;
		
		switch(menu) {
			case "햄버거" : price = 5000; break;
			case "짬뽕" : price = 4000; break;
			case "짜장면" : price = 4500; break;
			case "순대국" : price = 6000; break;
		}
		
		//4. 실행 결과 처리 및 전송
		request.setAttribute("menu", menu);
		request.setAttribute("price", price);
		
		//5. view에 위임(jsp에 위임)
		RequestDispatcher view = 
				request.getRequestDispatcher("views/04_menuResult.jsp");
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











