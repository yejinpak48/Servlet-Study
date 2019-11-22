package com.kh.jsp.notice.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.jsp.notice.model.service.NoticeService;
import com.kh.jsp.notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert.no")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String uno = request.getParameter("uno");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		
		System.out.println("date : " + date);
		
		java.sql.Date day = null;
		
		if(!date.equals("")) {
			/*String[] dateArr = date.split("-");
			
			int[] drr = new int[dateArr.length];
			
			for(int i = 0; i < dateArr.length; i++) {
				drr[i] = Integer.parseInt(dateArr[i]);
			}
			
			day = new java.sql.Date(new GregorianCalendar(drr[0], drr[1] - 1, drr[2]).getTimeInMillis());*/
			
			day = java.sql.Date.valueOf(date);
			
		}else {
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		System.out.println("day : " + day);
		
		Notice n = new Notice();
		n.setnTitle(title);
		n.setnWriter(uno);
		n.setnDate(day);
		n.setnContent(content);
		
		System.out.println("insert notice : " + n);
		
		
		int result = new NoticeService().insertNotice(n);
		
		String page = "";
		
		if(result > 0) {
			/*page = "views/notice/noticeList.jsp";
			request.setAttribute("list", new NoticeService().selectList());*/
			response.sendRedirect("/jsp/selectList.no");
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 등록 실패!!");
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













