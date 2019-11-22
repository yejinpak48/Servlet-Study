package com.kh.w6.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.w6.member.model.service.MemberService;
import com.kh.w6.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//로그인 처리를 위한 상수 필드 선언
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;
       
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
		//1. 전송 값에 한글이 있을 경우 인코딩 처리 해야 함
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//2. 전송값 꺼내서 변수에 기록하기
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
		
		Member reqMember = new Member();
		reqMember.setUserId(userId);
		reqMember.setPassword(password);
		
		//3. 비즈니스 로직을 처리할 서비스 클래스의 메소드로 전달값 넘김
		Member loginUser = new MemberService().loginCheck(reqMember);
		
		//System.out.println(loginUser);
		
		
		//4. 받은 결과에 따라서 성공/실패 페이지에 내보내기
		String view = "";
		if(loginUser.getStatus() == LOGIN_OK) {
			view = "views/main/main.jsp";
			
			//request.setAttribute("loginUser", loginUser);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect(view);
			
		}else {
			view = "views/common/errorPage.jsp";
			
			String msg;
			if(loginUser.getStatus() == WRONG_PASSWORD) {
				msg = "패스워드를 잘못 입력 하셨습니다.";
			}else {
				msg = "존재하지 않는 아이디입니다.";
			}
			
			request.setAttribute("msg", msg);
			
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
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












