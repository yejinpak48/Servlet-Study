package com.kh.w7.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//2. 전송값 꺼내 변수에 기록
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + password);
		
		//3. 서비스 로직 호출
		Member loginUser = new MemberService().loginCheck(userId, password);
		
		System.out.println("Controller loginUser : " + loginUser);
		
		//4. 받은 결과에 따른 뷰 페이지 내보내기
		String page = "";
		
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			page = "views/main/main.jsp";
			
			response.sendRedirect(page);
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "로그인 에러!!!");
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}











