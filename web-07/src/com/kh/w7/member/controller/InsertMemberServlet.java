package com.kh.w7.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String[] hobbyArr = request.getParameterValues("hobby");
		String hobby = "";
		
		for(int i = 0; i < hobbyArr.length; i++) {
			if(i == 0) {
				hobby += hobbyArr[i];
			}else {
				hobby += ", " + hobbyArr[i];
			}
		}
		
		Member m = new Member();
		m.setUserId(userId);
		m.setPassword(password);
		m.setUserName(userName);
		m.setGender(gender);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = new MemberService().insertMember(m);
		
		String page = "";
		
		if(result > 0) {
			page = "views/common/successPage.jsp";
			request.setAttribute("msg", "회원 가입에 성공하셨습니다!");
			response.sendRedirect(page + "?key=value");
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입에 실패하였습니다!");
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













