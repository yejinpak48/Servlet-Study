package com.kh.w7.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet("/searchMember")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = "";
		
		if(searchCondition.equals("findId")) {
			searchValue = request.getParameter("searchValue");
		}else if(searchCondition.equals("findName")) {
			searchValue = request.getParameter("searchValue");
		}else {
			searchValue = request.getParameter("gender");
		}
		
		System.out.println("searchCondition : " + searchCondition);
		System.out.println("searchValue : " + searchValue);
		
		ArrayList<Member> list = 
				new MemberService().searchMember(searchCondition, searchValue);
		
		System.out.println("controller list : " + list);
		
		String page = "";
		
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("searchCondition", searchCondition);
			
			page = "views/admin/searchResult.jsp";
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "검색 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














