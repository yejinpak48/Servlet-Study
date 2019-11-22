package com.kh.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.member.model.service.MemberService;
import com.kh.jsp.member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember.me")
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
		//request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String nickName = request.getParameter("nickName");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String phone = tel1 + "-" + tel2 + "-" + tel3;
		String email = request.getParameter("email");
		String zip = request.getParameter("zipCode");
		String add1 = request.getParameter("address1");
		String add2 = request.getParameter("address2");
		String address = zip + "$" + add1 + "$" + add2;
		String[] irr = request.getParameterValues("interest");
		String interest = "";
		
		if(irr != null) {
			for(int i = 0; i < irr.length; i++) {
				if(i == 0) {
					interest += irr[i];
				}else {
					interest += ", " + irr[i];
				}
			}
		}
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setNickName(nickName);
		m.setPhone(phone);
		m.setEmail(email);
		m.setAddress(address);
		m.setInterest(interest);
		
		System.out.println("Request Member : " + m);
	
		int result = new MemberService().insertMember(m);
		
		String page = "";
		
		if(result > 0) {
			page = "views/common/successPage.jsp";
			
			response.sendRedirect(page);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입실패!");
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












