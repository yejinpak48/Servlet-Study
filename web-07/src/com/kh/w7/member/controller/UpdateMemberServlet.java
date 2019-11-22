package com.kh.w7.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.service.MemberService;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateMember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		
		//전달값 꺼내기
		
		//서비스 호출
		//단, 아이디와 패스워드가 일치해야만 update가 되도록 쿼리문 작성
		/*int result = new MemberService().updateMember(m);
		
		//처리결과에 따른 뷰 페이지 결정
		String page = "";
		
		if(result > 0) {
			request.getSession().setAttribute("loginUser", m);
			
			response.sendRedirect("views/member/memberUpdateForm.jsp");
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 정보 수정에 실패하였습니다.");
			request.getRequestDispatcher(page).forward(request, response);
		}*/
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






